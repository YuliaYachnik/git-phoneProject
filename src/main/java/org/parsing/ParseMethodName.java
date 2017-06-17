package org.parsing;

/**
 * Created by Юлия on 17.06.2017.
 */
public class ParseMethodName {

    private final String[]  methodName;
    private final String method;

    private ParseMethodName(ParseMethodNameBilder bilder){
        this.methodName = bilder.methodName;
        this.method = bilder.method;
    }

    public String[] getMethodName() {
        return methodName;
    }

    public String getMethod() {
        return method;
    }

    public static class ParseMethodNameBilder{
        private final String[] methodName;
        private String method;

        public ParseMethodNameBilder(String[] methodName) {
            this.methodName = methodName;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public ParseMethodName build(){
            ParseMethodName parseMethodName = new ParseMethodName(this);
            startingParser(methodName);
            return parseMethodName;
        }


        public void startingParser(String[] args) throws ExceptionInInitializerError{
            String arguments[] = args;
            try{
                if(arguments.length == 0){
                    System.out.println("Error syntax. Please,use help-manager.");
                    System.exit(0);
                }
                else{
                    if(arguments.length > 5)
                    {
                        System.out.println("So much arguments in function invoke. Please,use help-manager.");
                        System.exit(0);
                    }
                    else{
                        if(arguments[0].equals("add")) setMethod("add");
                        else if (arguments[0].equals("find")) setMethod("find");
                        else if (arguments[0].equals("list")) setMethod("list");
                        else if (arguments[0].equals("help"))  setMethod("help");
                        else {
                            System.out.println("Error syntax. Please,use help-manager.");
                            System.exit(0);
                        }
                    }
                }
            }catch (ExceptionInInitializerError exceptionInInitializerError){
                System.out.println(exceptionInInitializerError);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
