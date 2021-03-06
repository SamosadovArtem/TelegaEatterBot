package com.telega.processors.impl;

import com.telega.eatter.Utils.BotUtils;
import com.telega.processors.MessageProcessor;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.Map;

public class RandomMessagesProcessor implements MessageProcessor {

    Map<String, String> messages = new HashMap<>();

    public RandomMessagesProcessor() {
        messages.put("/Артем", "Крест бля");
        messages.put("/ГруппаКрови", "На руковееее");
        messages.put("/ООО", "ПОШЛИ ВЫ ВСЕ НАХУЙ");
        messages.put("/Саня", "Ты в порядке?");
        messages.put("/OmaeWaMouShindeiru", "NANIIII????!!!!!");
        messages.put("/япошутил", ")))");

        String rules = "";
        rules += "Сообщение " + BotUtils.START_GAME_MESSAGE + " - начинает игру \n";
        rules += "Что бы внести свой ответ напиши - " + BotUtils.ANSWER_MESSAGE + " и цену(не забудь пробел) пример - " + BotUtils.ANSWER_MESSAGE + " 34.4 \n";
        rules += "Когда ведущий желает закончить игру - пишет " + BotUtils.FINISH_GAME_MESSAGE + " и цену, пример - " + BotUtils.FINISH_GAME_MESSAGE + " 25.5 \n";

        messages.put(BotUtils.HELP_MESSAGE, rules);

        final StringBuffer allWords = new StringBuffer();
        messages.entrySet().stream().map(Map.Entry::getKey).forEach( word -> allWords.append(word).append("\n"));

        messages.put("/чтоможешь", allWords.toString());

    }

    @Override
    public String process(Update update) {
        String message = update.getMessage().getText();
        String result = messages.get(message);
        return result != null ? result : "Да проще тебе ебало набить";
    }
}
