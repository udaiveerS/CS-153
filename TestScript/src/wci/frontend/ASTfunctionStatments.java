/* Generated By:JJTree: Do not edit this line. ASTfunctionStatments.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wci.frontend;

public
class ASTfunctionStatments extends SimpleNode {
  public ASTfunctionStatments(int id) {
    super(id);
  }

  public ASTfunctionStatments(PclParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(PclParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=040ded6f895523d9f2cfb8664c8e2a5d (do not edit this line) */