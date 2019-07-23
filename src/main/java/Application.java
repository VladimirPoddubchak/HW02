public class Application {
    public static void main(String[] args) {
        String testString = "{{[()]}()}()[][][][][][][][][][][][][][][][][][][][][][][][][][][][]";
        String testString2 = "[]";
        String testString3 = "{}{}{";
        String testString4 = "{}{}{t";
        String testString5 = "{}{}><";
        String testString6 = "{}{}<>";
        String testString7 = "{}{}<>(())";

        try {
            System.out.println(CorrectBracketSequenceChecker.checkSequence(testString));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

        try {
            System.out.println(CorrectBracketSequenceChecker.checkSequence(testString2));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        try {
            System.out.println(CorrectBracketSequenceChecker.checkSequence(testString3));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        try {
            System.out.println(CorrectBracketSequenceChecker.checkSequence(testString4));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        try {
            System.out.println(CorrectBracketSequenceChecker.checkSequence(testString5));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        try {
            System.out.println(CorrectBracketSequenceChecker.checkSequence(testString6));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        try {
            System.out.println(CorrectBracketSequenceChecker.checkSequence(testString7));
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

        System.out.println("SuccessCount = "+CorrectBracketSequenceChecker.getSuccessChecksCount());
        System.out.println("FailCount = "+CorrectBracketSequenceChecker.getFailChecksCount());
        System.out.println("LastSuccessSequence = " +CorrectBracketSequenceChecker.getLastSuccessSequence());

    }
}
