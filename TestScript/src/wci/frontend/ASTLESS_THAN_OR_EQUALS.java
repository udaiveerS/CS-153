/* Generated By:JJTree: Do not edit this line. ASTLESS_THAN_OR_EQUALS.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wci.frontend;

public
class ASTLESS_THAN_OR_EQUALS extends SimpleNode {
  public ASTLESS_THAN_OR_EQUALS(int id) {
    super(id);
  }

  public ASTLESS_THAN_OR_EQUALS(TypeScriptParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(TypeScriptParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=42b5a070182a5255e0843c181f5635ea (do not edit this line) */
