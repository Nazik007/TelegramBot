package support_classes;

import default_set.bot_settings.ChatSetting;

import java.util.ArrayList;
import java.util.List;

public class InMemorySupport implements Support{

    private final List<ChatSetting> chatSettings;

    public InMemorySupport() {
        this.chatSettings = new ArrayList<>();
    }

    @Override
    public boolean  contains(long chatId) {
        return chatSettings.stream().anyMatch(chatSetting -> chatSetting.getChatId() == chatId);
    }

    @Override
    public void add(long chatId, ChatSetting chatSetting) {
        for (int i = 0; i < chatSettings.size(); i++) {
            if (chatSettings.get(i).getChatId() == chatId) {
                chatSettings.set(i, chatSetting);
                return;
            }
        }
        chatSettings.add(chatSetting);
    }

    @Override
    public void delete (long chatId) {
        for (int i = 0; i < chatSettings.size(); i++) {
            if (chatSettings.get(i).getChatId() == chatId) {
                chatSettings.remove(i);
                return;
            }
        }
    }

    @Override
    public ChatSetting getSetting(long chatId) {
        for (ChatSetting chatSetting : chatSettings) {
            if (chatSetting.getChatId() == chatId) {
                return chatSetting;
            }
        }
        return null;
    }

    @Override
    public List<ChatSetting> getListOfSettings() {
        return  List.copyOf(chatSettings);
    }
}
