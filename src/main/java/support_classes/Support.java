package support_classes;

import default_set.bot_settings.ChatSetting;

import java.util.List;

public interface Support {

    boolean contains (long chatId);

    void add (long chatId, ChatSetting chatSetting);

    void delete (long chatId);

    ChatSetting getSetting (long chatId);

    List<ChatSetting>  getListOfSettings ();
}
