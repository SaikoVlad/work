package by.bntu.fitr.povt.model;

public class Nastroi {

    public static String nastroi(int x) {
        switch (x) {
            case 0:
                return "У тебя сейчас среднее настроение( ты в нормальном состоянии):\n" +
                        "                                               ¯\\_(ー_ー )_/¯";
            case 1:
                return "У тебя сейчас хорошее настроение( ты готов радоваться и веселиться):\n" +
                        "                                               \\(⌒ω⌒)/";
            case 2:
                return "У тебя сейчас очень хорошее настроение( ты готоы нести радость всем в округе): \n" +
                        "                                               ╰(✯∀✯)╯";
            case 3:
                return "У тебя сейчас плохое настроение( ты о чем то сильно сожалеешь...): \n" +
                        "                                               /(￣︿￣)\\";
            default:
                return "У тебя сейчас очень плохое настроение( оу, сейчас тебя лучше не трогать): \n" +
                        "                                               \\(◣_◢)/";
        }
    }
}