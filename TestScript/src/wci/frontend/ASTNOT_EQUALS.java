/* Generated By:JJTree: Do not edit this line. ASTNOT_EQUALS.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=wci.intermediate.icodeimpl.ICodeNodeImpl,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package wci.frontend;

public
class ASTNOT_EQUALS extends SimpleNode {
  public ASTNOT_EQUALS(int id) {
    super(id);
  }

  public ASTNOT_EQUALS(PclParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(PclParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=78a2ab4961d680ef91fbb817995329d1 (do not edit this line) */
