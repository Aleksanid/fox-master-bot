package ua.aleksanid.foxmasterbot.bot.foxmaster;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoxMasterBot extends TelegramBot {

    private static final Logger logger = LoggerFactory.getLogger(FoxMasterBot.class);

    public FoxMasterBot(@Value("${bot.token}") String botToken) {
        super(botToken);
        this.setUpdatesListener(new UpdatesListenerImpl());
    }


    public void SendMessage(String message, Long receiverId){
        SendMessage sendMessageRequest = new SendMessage(receiverId,message);

        this.execute(sendMessageRequest);
    }

    private class UpdatesListenerImpl implements UpdatesListener {
        @Override
        public int process(List<Update> updates) {
            for (Update update: updates) {
                logger.info(update.toString());
                if(update.message().text()!=null) {
                    SendMessage("Received: " + update.message().text(), update.message().from().id());
                }
            }
            return CONFIRMED_UPDATES_ALL;
        }
    }

}
