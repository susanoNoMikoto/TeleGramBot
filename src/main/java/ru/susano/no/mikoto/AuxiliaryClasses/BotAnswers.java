package ru.susano.no.mikoto.AuxiliaryClasses;

public enum BotAnswers {

    WELCOME_MESSAGE(
            "Привет, это бот созданный @Susano_no_mikoto. \n" +
            "Этот бот задумывался как посредник между внешним миром и Susano. \n" +
            "Если тебе нужна помощь в управлении ботом отправь команду /help"
    );


    public final String answer;

    BotAnswers(String answer) {
        this.answer = answer;
    }

    public String getText() {
        return answer;
    }
}
