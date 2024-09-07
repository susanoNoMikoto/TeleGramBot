package ru.susano.no.mikoto.AuxiliaryClasses;

public enum BotAnswers {

    WELCOME_MESSAGE(
            "������. ��� ��� ��������� @Susano_no_mikoto. \n" +
            "���� ��� ����������� ��� ��������� ����� ������� ����� � Susano. \n" +
            "���� ���� ����� ������ � ���������� ����� ������� ������� /help"
    ),
    HELP_MESSAGE(
            "������ \n"+
            "��� \n"
    ),
    ADMIN_PASSWORD(
            "������� ������"
    ),
    STOP_MESSAGE(
            "����"
    ),
    NOT_COMMAND_MESSAGE(
            "�� ���� �� ������������� ������"
    );


    public final String answer;

    BotAnswers(String answer) {
        this.answer = answer;
    }

    public String getText() {
        return answer;
    }
}
