import com.sun.istack.internal.Nullable;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;


public final class CorrectBracketSequenceChecker {

    private final static int MAX_SIZE = 100;
    private static int successChecksCount;
    private static int failChecksCount;
    private static String lastSuccessSequence;
    private static Map<Character,Character> brackets = new HashMap<Character, Character>() {{
        put('(',')');
        put('[',']');
        put('{','}');
        put('<','>');
    }};
    private CorrectBracketSequenceChecker() {
        /* todo: append code if needed */
    }

    /**
     * Метод проверяющий скобочную последовательность на правильность.
     * <p>
     * Пустая строка
     * — правильная скобочная последовательность.
     * Правильная скобочная последовательность, взятая в скобки одного типа
     * — правильная скобочная последовательность.
     * Правильная скобочная последовательность,
     * к которой слева или справа приписана правильная скобочная последовательность
     * — правильная скобочная последовательность.
     * <p>
     * Последовательности из больше чем ста символов или с символами не скобок — некорректные.
     * <p>
     * Скобки бывают:
     * 1. Круглые '(', ')'
     * 2. Квадратные '[', ']'
     * 3. Фигурные '{', '}'
     *
     * @param sequence — входная строка
     * @return {@code true} — если скобочная последовательность корректна и {@code false} иначе
     * @throws IllegalArgumentException если в строке содержатся символы, не являющиеся скобками
     *                                  или если входная строка содержит больше ста символов
     */

    public static boolean checkSequence(@Nullable String sequence) throws IllegalArgumentException{


        if (sequence.length()>MAX_SIZE){
            failChecksCount++;
//            throw new  IllegalArgumentException("Length should be < 100");
            throw new  IllegalArgumentException();
        }

        if (sequence.length()%2 !=0) {
            failChecksCount++;
            throw new  IllegalArgumentException("String length %2 should be = 0");
        }

        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (int counter = 0; counter < sequence.length();counter++){

            char c =sequence.charAt(counter);

            if (!brackets.containsKey(c)&&!brackets.containsValue(c)){
                failChecksCount++;
                throw new  IllegalArgumentException("Wrong symbols");
            }

            if (brackets.containsKey(c)){
                stack.addLast(c);
            }else {

                if (brackets.containsValue(c) && !stack.isEmpty() && brackets.get(stack.getLast()) == c ) {
                    stack.pollLast();
                } else {
                    failChecksCount++;
                    throw new  IllegalArgumentException("Wrong order of symbols");
                }
            }
        }

        lastSuccessSequence = sequence;
        successChecksCount++;
        return true;
    }

    /**
     * Возвращает количество проверок, в результате которых выяснилось,
     * что входная строка является правильной скобочной последовательностью.
     *
     * @return количество удачных проверок
     */
    public static int getSuccessChecksCount() {
        return successChecksCount;
    }

    /**
     * Возвращает количество проверок, в результате которых выяснилось,
     * что входная строка не является правильной скобочной последовательностью.
     *
     * @return количество неудачных проверок
     */
    public static int getFailChecksCount() {
        return failChecksCount;
    }

    /**
     * Возвращает последнюю последовательность, проверка которой завершилась успешно.
     *
     * @return последняя правильная скобочная последовательность или null если такой ещё не было
     */
    public static @Nullable String getLastSuccessSequence() {
        return lastSuccessSequence;
    }
}
