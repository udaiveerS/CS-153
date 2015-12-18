# Assignment 5 Requirements

### Generate a Java scanner with JavaCC
Use JavaCC to generate a simple tokenizer (i.e., scanner) that recognizes the tokens of the Java programming language.

For this assignment, you do not need to recognize the special meaning of the
\ character in character and string tokens. Therefore:
* A **character token** is a single character only surrounded by single quotes (').
* The \ character has no special meaning inside a string token.
* A **string token** cannot span multiple lines.
* A **comment** surrounded by /* and */ can span multiple lines.

The purpose of this assignment is to become familiar with JavaCC. Therefore,
* It is not necessary to make the output pretty, just readable. For each recognized
token, simply print a line that includes the type of token (e.g., identifier, reserved word auto, colon-equals) and the token string.
* Recognition of reserved words should be case sensitive.
* The tokenizer should skip over comments.
* **You may assume for this assignment that the input file contains no errors.**

### Input file input.txt
You must run your program with the following input file. There should be no invisible control characters other than blanks and line feeds.

    /* This is a comment. */
    // So is this.
    /* Here's a comment
     that spans several
     source lines. */
    Two/*comments in*//***a row***/ here.
    /* This is /* not a nested comment. */
    // Nor is /* this */ one.
    // Word tokens
    Hello world
    Abstract abstract ABSTRACT aBsTrAcT
    What_is_that?
    // Character tokens
    'x' 'A' '\' 'b'
    // String tokens
    "Hello, world."
    "It's Friday!"
    ""
    // Special symbol tokens
    + - * / := . , ; : = <> < <= >= > ( ) [ ] { } } ^ ..
    <<= >>=
    :=<>=<==>>===
    // Number tokens
    0 1 12.0 00000000000000000012 .12 1..2
    012 0x12 0xAb 0x0E12
    12. 0.12 .12 1.2e+2 12e+2 12e2 0e2
    12e-2 12e-5 .12e+2 12.e+2 12e-1 12e12
    .31415926 3.1415926
    0.00031415926E4 0.00031415926e+00004 31415.926e-4
    3141592600000000000000000000000e-30
    // Actual Java code
    /**
    * Parse a REPEAT statement.
    * @param token the initial token.
    * @return the root node of the generated parse tree.
    * @throws Exception if an error occurred.
    */
    public ICodeNode parse(Token token) throws Exception
    {
         token = nextToken(); // consume the REPEAT
         // Create the LOOP and TEST nodes.
         ICodeNode loopNode = ICodeFactory.createICodeNode(LOOP);
         ICodeNode testNode = ICodeFactory.createICodeNode(TEST);
         // Parse the statement list terminated by the UNTIL token.
         // The LOOP node is the parent of the statement subtrees.
         StatementParser statementParser = new StatementParser(this);
         statementParser.parseList(token, loopNode, UNTIL, MISSING_UNTIL);
         token = currentToken();
         // Parse the expression.
         // The TEST node adopts the expression subtree as its only child.
         ExpressionParser expressionParser = new ExpressionParser(this);
         ICodeNode exprNode = expressionParser.parse(token);
         testNode.addChild(exprNode);
         loopNode.addChild(testNode);
         // Type check: The test expression must be boolean.
        TypeSpec exprType = exprNode != null ? exprNode.getTypeSpec()
        : Predefined.undefinedType;
        if (!TypeChecker.isBoolean(exprType)) {
        errorHandler.flag(token, INCOMPATIBLE_TYPES, this);
     }
     return loopNode;
    }