/* Generated By:JJTree: Do not edit this line. ASTTurnRight.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTTurnRight extends SimpleNode {
  public ASTTurnRight(int id) {
    super(id);
  }

  public ASTTurnRight(Logo p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(LogoVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=3ac5dcc8d2b1bb08c27c6d62ded1e3de (do not edit this line) */