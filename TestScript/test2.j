.class public TypeScriptProgram
.super java/lang/Object

.field private static i F
.field private static j F
.field private static l B
.field private static s F
.field private static x C
.field private static y F

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

      ldc 1.0
      ldc 5.653
      fsub
      ldc 4434.0
      fadd
      putstatic TypeScriptProgram/i F
      ldc 2.0
      getstatic TypeScriptProgram/i F
      fadd
      putstatic TypeScriptProgram/j F
      ldc "hello person"
      putstatic TypeScriptProgram/x C
      getstatic TypeScriptProgram/true B
      putstatic TypeScriptProgram/l B
      ldc 1.0
      ldc 2.0
      fadd
      ldc 3.0
      fadd
      putstatic TypeScriptProgram/y F
      ldc 10.0
      ldc 5.0
      fdiv
      putstatic TypeScriptProgram/s F
      ldc 6.0
      putstatic TypeScriptProgram/y F

    return

.limit stack 16
.end method
