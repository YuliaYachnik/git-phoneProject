package org.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseArguments {

    private String name = "";
    private String phone = "";
    private String file = "phonebook.txt";
    private String filedir = "phonebook";

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setFiledir(String filedir) {
        this.filedir = filedir;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFile() {
        return file;
    }

    public String getFiledir() {
        return filedir;
    }

    public ParseArguments() {
    }

    public ParseArguments(String name) {
        this.name = name;
    }

    public ParseArguments(String name, String phone, String file, String filedir) {
        this.name = name;
        this.phone = phone;
        this.file = file;
        this.filedir = filedir;
    }

    @Override
    public String toString() {
        return "ParseArguments{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", file='" + file + '\'' +
                ", filedir='" + filedir + '\'' +
                '}';
    }

    public ParseArguments(String name, String phone, String file) {
        this.name = name;
        this.phone = phone;
        this.file = file;
    }

    public ParseArguments(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public ParseArguments checkArgumentforHelp(String[] arguments) throws Exception {
        ParseArguments parseArguments = null;
        try {
            int countArguments = arguments.length;
            if (countArguments == 0)
                System.out.println("No parameters have been entered.Please,use help-manager. ");
            else {
                if ((arguments[0].equals("help") || arguments[0].equals("Help")) && countArguments > 1)
                    throw new ExceptionInInitializerError();
                if (arguments[0].equals("help") || arguments[0].equals("Help")) {
                    parseArguments = new ParseArguments();
                }
            }
            return parseArguments;
        } catch (ExceptionInInitializerError exceptionInInitializerError) {
            System.out.println("Error of Initializing parameters.Please,use help-manager");
            return null;
        }
    }

    public ParseArguments checkArgumentforList(String[] arguments) throws Exception {
        ParseArguments parseArguments = null;
        try {
            int countArguments = arguments.length;
            if (countArguments == 0)
                System.out.println("No parameters have been entered.Please,use help-manager. ");
            if ((arguments[0].equals("list") || arguments[0].equals("List")) && countArguments == 1) {
                parseArguments = new ParseArguments();
            } else if ((arguments[0].equals("list") || arguments[0].equals("List")) && countArguments == 2)
                throw new ExceptionInInitializerError();
            else if ((arguments[0].equals("list") || arguments[0].equals("List")) && countArguments > 3)
                throw new ExceptionInInitializerError();
            else if ((arguments[0].equals("list") || arguments[0].equals("List")) && countArguments == 3 && (arguments[1].contains("--phone") || arguments[1].contains("--name"))
                    && (arguments[2].contains("--name") || arguments[2].contains("--phone")))
                throw new ExceptionInInitializerError();
            else if ((arguments[0].equals("list") || arguments[0].equals("List")) && countArguments == 3) {
                parseArguments = new ParseArguments();
                parseArguments.setFile(getFileName(arguments[1]));
                parseArguments.setFiledir(getFileDir(arguments[2]));
            }
            return parseArguments;
        } catch (NullPointerException e) {
            System.out.println("Error with passing parameters to the command line.Please,use help-manager");
            return null;
        } catch (ExceptionInInitializerError exceptionInInitializerError) {
            System.out.println("Error of Initializing parameters.Please,use help-manager.");
            return null;
        }
    }

    public ParseArguments checkArgumentforFind(String[] arguments) throws Exception {
        ParseArguments parseArguments = null;
        try {
            int countArguments = arguments.length;
            if (countArguments == 0)
                System.out.println("No parameters have been entered.Please,use help-manager.");
            else if (countArguments < 2)
                throw new NullPointerException();
            else if ((arguments[0].equals("find") || arguments[0].equals("Find")) && countArguments == 2) {
                String bufName = getName(arguments[1]);
                if (bufName == null)
                    throw new NullPointerException();
                else
                    parseArguments = new ParseArguments(getName(arguments[1]));
            } else if ((arguments[0].equals("find") || arguments[0].equals("Find")) && countArguments == 4) {
                String bufName = getName(arguments[1]);
                String bufFileName = getFileName(arguments[2]);
                String bufDirName = getFileDir(arguments[3]);
                if (bufName == null || bufFileName == null || bufDirName == null)
                    throw new NullPointerException();
                else {
                    parseArguments = new ParseArguments();
                    parseArguments.setName(getName(arguments[1]));
                    parseArguments.setFile(getFileName(arguments[2]));
                    parseArguments.setFiledir(getFileDir(arguments[3]));
                }
            } else if ((arguments[0].equals("find") || arguments[0].equals("Find")) && countArguments == 4 && arguments[2].contains("--phone="))
                throw new ExceptionInInitializerError();
            else if ((arguments[0].equals("find") || arguments[0].equals("Find")) && countArguments == 3)
                throw new ExceptionInInitializerError();
            return parseArguments;
        } catch (NullPointerException e) {
            System.out.println("Error with passing parameters to the command line.Please,use help-manager");
            return null;
        } catch (ExceptionInInitializerError exceptionInInitializerError) {
            System.out.println("Error of Initializing parameters.Please,use help-manager.");
            return null;
        }
    }


    public ParseArguments checkArgumentforAdd(String[] arguments) throws Exception {
        ParseArguments parseArguments = null;
        int countArguments = arguments.length;
        try {
            if (countArguments == 0)
                System.out.println("No parameters have been entered.Please,use help-manager.");
            else if (countArguments < 3)
                throw new NullPointerException();
            else if ((arguments[0].equals("add") || arguments[0].equals("Add")) && countArguments == 3) {
                String bufName = getName(arguments[1]);
                String bufPhone = getPhone(arguments[2]);
                if (bufName == null || bufPhone == null)
                    throw new NullPointerException();
                else
                    parseArguments = new ParseArguments(getName(arguments[1]), getPhone(arguments[2]));
            } else if ((arguments[0].equals("add") || arguments[0].equals("Add")) && countArguments == 4 && arguments[3].contains("--filename=")) {
                String bufName = getName(arguments[1]);
                String bufPhone = getPhone(arguments[2]);
                String bufFileName = getFileName(arguments[3]);
                if (bufName == null || bufPhone == null || bufFileName == null)
                    throw new NullPointerException();
                else
                    parseArguments = new ParseArguments(getName(arguments[1]), getPhone(arguments[2]), getFileName(arguments[3]));
            } else if ((arguments[0].equals("add") || arguments[0].equals("Add")) && countArguments == 5) {
                String bufName = getName(arguments[1]);
                String bufPhone = getPhone(arguments[2]);
                String bufFileName = getFileName(arguments[3]);
                String bufDirName = getFileDir(arguments[4]);
                if (bufName == null || bufPhone == null || bufFileName == null || bufDirName == null)
                    throw new NullPointerException();
                else
                    parseArguments = new ParseArguments(getName(arguments[1]), getPhone(arguments[2]), getFileName(arguments[3]), getFileDir(arguments[4]));
            } else if ((arguments[0].equals("add") || arguments[0].equals("Add")) && countArguments == 4 && arguments[3].contains("--dirname="))
                throw new ExceptionInInitializerError();

            return parseArguments;
        } catch (NullPointerException e) {
            System.out.println("Error with passing parameters to the command line.Please,use help-manager");
            return null;
        } catch (ExceptionInInitializerError exceptionInInitializerError) {
            System.out.println("Error of Initializing parameters.Please,use help-manager.");
            return null;
        }
    }

    public static boolean checkNameSymbol(String str) {
        Pattern p = Pattern.compile("^--name=+[a-zA-ZА-Яа-я]{3,15}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean checkPhoneSymbol(String str) {
        Pattern p = Pattern.compile("^--phone=+[0-9]{3,20}$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean checkFileName(String str) {
        Pattern p = Pattern.compile("\\[--filename=.+\\.txt\\]");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static boolean checkFileDir(String str) {
        Pattern p = Pattern.compile("\\[--dirname=+[a-zA-ZА-Яа-я0-9]{3,15}\\]");
        Matcher m = p.matcher(str);
        return m.matches();
    }


    public String getName(String str) throws Exception {
        try {
            String returnName = "";
            if (checkNameSymbol(str) == true) {
                for (String value : str.split("=")) {
                    returnName = value;
                }
                return returnName;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect name data.Please,use help-manager.");
            return null;
        }
    }

    public String getPhone(String str) throws Exception {
        try {
            if (checkPhoneSymbol(str) == true) {
                String returnPhone = "";
                for (String value : str.split("=")) {
                    returnPhone = value;
                }
                return returnPhone;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect phone number. Please,use help-manager.");
            return null;
        }
    }

    public String getFileName(String str) throws Exception {
        try {
            if (checkFileName(str) == true) {
                String returnFileName = "";
                for (String value : str.split("=")) {
                    returnFileName = value;
                }
                return returnFileName.substring(0, returnFileName.length() - 1);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect file name. Please,use help-manager.");
            return null;
        }
    }

    public String getFileDir(String str) throws Exception {
        try {
            if (checkFileDir(str) == true) {
                String returnFileDir = "";
                for (String value : str.split("=")) {
                    returnFileDir = value;
                }
                return returnFileDir.substring(0, returnFileDir.length() - 1);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Incorrect name of directory. Please,use help-manager.");
            return null;
        }
    }
}
