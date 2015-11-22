package wci.intermediate.typeimpl;

import wci.intermediate.*;
import wci.intermediate.symtabimpl.*;
import wci.intermediate.typeimpl.*;

import static wci.intermediate.typeimpl.TypeFormImpl.*;
import static wci.intermediate.typeimpl.TypeKeyImpl.*;

/**
 * <h1>TypeChecker</h1>
 *
 * <p>Perform type checking.</p>
 *
 * <p>Copyright (c) 2008 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class TypeChecker
{
    /**
     * Check if a type specification is integer.
     * @param type the type specification to check.
     * @return true if integer, else false.
     */
    public static boolean isNumber(TypeSpec type)
    {
        return (type != null) && (type.baseType() == Predefined.numberType);
    }

    /**
     * Check if both type specifications are integer.
     * @param type1 the first type specification to check.
     * @param type2 the second type specification to check.
     * @return true if both are integer, else false.
     */
    public static boolean areBothNumber(TypeSpec type1, TypeSpec type2)
    {
        return isNumber(type1) && isNumber(type2);
    }



    /**
     * Check if a type specification is boolean.
     * @param type the type specification to check.
     * @return true if boolean, else false.
     */
    public static boolean isBoolean(TypeSpec type)
    {
        return (type != null) && (type.baseType() == Predefined.booleanType);
    }

    /**
     * Check if both type specifications are boolean.
     * @param type1 the first type specification to check.
     * @param type2 the second type specification to check.
     * @return true if both are boolean, else false.
     */
    public static boolean areBothBoolean(TypeSpec type1, TypeSpec type2)
    {
        return isBoolean(type1) && isBoolean(type2);
    }

    /**
     * Check if a type specification is char.
     * @param type the type specification to check.
     * @return true if char, else false.
     */
    public static boolean isChar(TypeSpec type)
    {
        return (type != null) && (type.baseType() == Predefined.charType);
    }

    /**
     * Check if two type specifications are assignment compatible.
     * @param targetType the target type specification.
     * @param valueType the value type specification.
     * @return true if the value can be assigned to the target, else false.
     */
    public static boolean areAssignmentCompatible(TypeSpec targetType,
                                                  TypeSpec valueType)
    {
        if ((targetType == null) || (valueType == null)) {
            return false;
        }

        targetType = targetType.baseType();
        valueType  = valueType.baseType();

        boolean compatible = false;

        // Identical types.
        if (targetType == valueType) {
            compatible = true;
        }

        // real := integer
        else if (isNumber(targetType) && isNumber(valueType)) {
            compatible = true;
        }

        // Equal length strings
        else {
            compatible = equalLengthStrings(targetType, valueType);
        }

        return compatible;
    }

    /**
     * Check if two type specifications are comparison compatible.
     * @param type1 the first type specification to check.
     * @param type2 the second type specification to check.
     * @return true if the types can be compared to each other, else false.
     */
    public static boolean areComparisonCompatible(TypeSpec type1,
                                                  TypeSpec type2)
    {
        if ((type1 == null) || (type2 == null)) {
            return false;
        }

        type1 = type1.baseType();
        type2 = type2.baseType();
        TypeForm form = type1.getForm();

        boolean compatible = false;

        // Two identical scalar or enumeration types.
        if ((type1 == type2) && ((form == SCALAR) || (form == ENUMERATION))) {
            compatible = true;
        }

        // One integer and one real.
        else if (isNumber(type1) && isNumber(type2)) {
            compatible = true;
        }

        // Equal length strings
        else {
            compatible = equalLengthStrings(type1, type2);
        }

        return compatible;
    }

    /**
     * Check if two string type specifications are of equal length.
     * @param type1 the first type specification to check.
     * @param type2 the second type specification to check.
     * @return true if the string types are equal length, else false.
     */
    private static boolean equalLengthStrings(TypeSpec type1, TypeSpec type2)
    {
        boolean equal = false;

        if ((type1 != null) && (type2 != null) &&
            (type1.getForm() == ARRAY) && (type2.getForm() == ARRAY))
        {
            TypeSpec elmtType1 =
                (TypeSpec) type1.getAttribute(ARRAY_ELEMENT_TYPE);
            TypeSpec elmtType2 =
                (TypeSpec) type2.getAttribute(ARRAY_ELEMENT_TYPE);

            if (isChar(elmtType1) && isChar(elmtType2)) {
                int elmtCount1 =
                    (Integer) type1.getAttribute(ARRAY_ELEMENT_COUNT);
                int elmtCount2 =
                    (Integer) type2.getAttribute(ARRAY_ELEMENT_COUNT);

                equal = elmtCount1 == elmtCount2;
            }
        }

        return equal;
    }
}
