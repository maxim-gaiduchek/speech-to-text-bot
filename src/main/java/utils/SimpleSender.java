package utils;

import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.AnswerInlineQuery;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.LeaveChat;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.games.Animation;
import org.telegram.telegrambots.meta.api.objects.inlinequery.result.InlineQueryResult;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.stickers.Sticker;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gaiduchek Maxim
 * @version 1.0
 * API version must be 4.0+
 */

public class SimpleSender extends DefaultAbsSender {

    private final String TOKEN;

    public SimpleSender(String token) {
        this(token, ApiContext.getInstance(DefaultBotOptions.class));
    }

    public SimpleSender(String token, DefaultBotOptions options) {
        super(options);
        TOKEN = token;
    }

    // string

    public synchronized Message sendString(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendString(Long chatId, String text) {
        return sendString(chatId.toString(), text);
    }

    public synchronized Message sendStringWithDisabledNotifying(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.enableMarkdown(true);
        sendMessage.disableNotification();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendStringWithDisabledNotifying(Long chatId, String text) {
        return sendStringWithDisabledNotifying(chatId.toString(), text);
    }

    public synchronized Message sendStringWithDisabledWebPagePreview(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.enableMarkdown(true);
        sendMessage.disableWebPagePreview();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendStringWithDisabledWebPagePreview(Long chatId, String text) {
        return sendStringWithDisabledWebPagePreview(chatId.toString(), text);
    }

    public synchronized Message sendString(String chatId, String text, Integer replyToMessageId) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyToMessageId(replyToMessageId);

        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendString(Long chatId, String text, Integer replyToMessageId) {
        return sendString(chatId.toString(), text, replyToMessageId);
    }

    public synchronized Message sendString(String chatId, String text, boolean enableMarkdown) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(enableMarkdown);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendString(Long chatId, String text, boolean enableMarkdown) {
        return sendString(chatId.toString(), text, enableMarkdown);
    }

    public synchronized Message sendString(String chatId, String text, Integer replyToMessageId, boolean enableMarkdown) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(enableMarkdown);
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyToMessageId(replyToMessageId);
        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendString(Long chatId, String text, Integer replyToMessageId, boolean enableMarkdown) {
        return sendString(chatId.toString(), text, replyToMessageId, enableMarkdown);
    }

    // photo

    public synchronized Message sendPhoto(String chatId, List<PhotoSize> photo) {
        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(photo.get(0).getFileId());

        try {
            return execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendPhoto(Long chatId, List<PhotoSize> photo) {
        return sendPhoto(chatId.toString(), photo);
    }

    public synchronized Message sendPhoto(String chatId, List<PhotoSize> photo, String caption) {
        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(chatId);
        sendPhoto.setCaption(caption);
        sendPhoto.setParseMode("Markdown");
        sendPhoto.setPhoto(photo.get(0).getFileId());

        try {
            return execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendPhoto(Long chatId, List<PhotoSize> photo, String caption) {
        return sendPhoto(chatId.toString(), photo, caption);
    }

    public synchronized Message sendPhoto(String chatId, String photoId) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(photoId);
        try {
            return execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendPhoto(Long chatId, String photoId) {
        return sendPhoto(chatId.toString(), photoId);
    }

    public synchronized Message sendPhoto(String chatId, String photoId, String caption) {
        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(photoId);
        sendPhoto.setCaption(caption);
        sendPhoto.setParseMode("Markdown");

        try {
            return execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendPhoto(Long chatId, String photoId, String caption) {
        return sendPhoto(chatId.toString(), photoId, caption);
    }

    public synchronized Message sendPhoto(String chatId, String photoId, String caption, List<KeyboardRow> keyboard) {
        SendPhoto sendPhoto = new SendPhoto();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        replyKeyboardMarkup.setKeyboard(keyboard);

        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(photoId);
        sendPhoto.setCaption(caption);
        sendPhoto.setParseMode("Markdown");
        sendPhoto.setReplyMarkup(replyKeyboardMarkup);

        try {
            return execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendPhoto(Long chatId, String photoId, String caption, List<KeyboardRow> keyboard) {
        return sendPhoto(chatId.toString(), photoId, caption, keyboard);
    }

    public synchronized Message sendPhotoAndInlineKeyboard(String chatId, String photoId, String caption, List<List<InlineKeyboardButton>> keyboard) {
        SendPhoto sendPhoto = new SendPhoto();
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        markup.setKeyboard(keyboard);

        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(photoId);
        sendPhoto.setCaption(caption);
        sendPhoto.setParseMode("Markdown");
        sendPhoto.setReplyMarkup(markup);

        try {
            return execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendPhotoAndInlineKeyboard(Long chatId, String photoId, String caption, List<List<InlineKeyboardButton>> keyboard) {
        return sendPhotoAndInlineKeyboard(chatId.toString(), photoId, caption, keyboard);
    }

    // video

    public synchronized Message sendVideo(String chatId, Video video) {
        SendVideo sendVideo = new SendVideo();
        sendVideo.setChatId(chatId);
        sendVideo.setVideo(video.getFileId());
        try {
            return execute(sendVideo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendVideo(Long chatId, Video video) {
        return sendVideo(chatId.toString(), video);
    }

    public synchronized Message sendVideo(String chatId, Video video, String caption) {
        SendVideo sendVideo = new SendVideo();
        sendVideo.setChatId(chatId);
        sendVideo.setCaption(caption);
        sendVideo.setParseMode("MarkdownV2");
        sendVideo.setVideo(video.getFileId());
        try {
            return execute(sendVideo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendVideo(Long chatId, Video video, String caption) {
        return sendVideo(chatId.toString(), video, caption);
    }

    // video note

    public synchronized Message sendVideoNote(String chatId, VideoNote videoNote) {
        SendVideoNote sendVideoNote = new SendVideoNote();
        sendVideoNote.setChatId(chatId);
        sendVideoNote.setVideoNote(videoNote.getFileId());
        try {
            return execute(sendVideoNote);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendVideoNote(Long chatId, VideoNote videoNote) {
        return sendVideoNote(chatId.toString(), videoNote);
    }

    // voice

    public synchronized Message sendVoice(String chatId, Voice voice) {
        SendVoice sendVoice = new SendVoice();

        sendVoice.setChatId(chatId);
        sendVoice.setVoice(voice.getFileId());

        try {
            return execute(sendVoice);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendVoice(Long chatId, Voice voice) {
        return sendVoice(chatId.toString(), voice);
    }

    // audio

    public synchronized Message sendAudio(String chatId, Audio audio) {
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(chatId);
        sendAudio.setAudio(audio.getFileId());
        try {
            return execute(sendAudio);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendAudio(Long chatId, Audio audio) {
        return sendAudio(chatId.toString(), audio);
    }

    // sticker

    public synchronized Message sendSticker(String chatId, Sticker sticker) {
        SendSticker sendSticker = new SendSticker();
        sendSticker.setChatId(chatId);
        sendSticker.setSticker(sticker.getFileId());
        try {
            return execute(sendSticker);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendSticker(Long chatId, Sticker sticker) {
        return sendSticker(chatId.toString(), sticker);
    }

    // contact

    public synchronized Message sendContact(String chatId, Contact contact) {
        SendContact sendContact = new SendContact();
        sendContact.setChatId(chatId);
        sendContact.setPhoneNumber(contact.getPhoneNumber());
        sendContact.setFirstName(contact.getFirstName());
        sendContact.setLastName(contact.getLastName());
        try {
            return execute(sendContact);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendContact(Long chatId, Contact contact) {
        return sendContact(chatId.toString(), contact);
    }

    // location

    public synchronized Message sendLocation(String chatId, Location location) {
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLongitude(location.getLongitude());
        sendLocation.setLatitude(location.getLatitude());
        try {
            return execute(sendLocation);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendLocation(Long chatId, Location location) {
        return sendLocation(chatId.toString(), location);
    }

    // document

    public synchronized Message sendDocument(String chatId, Document document) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setDocument(document.getFileId());
        try {
            return execute(sendDocument);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendDocument(Long chatId, Document document) {
        return sendDocument(chatId.toString(), document);
    }

    public synchronized Message sendDocument(String chatId, String fileId) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setDocument(fileId);
        try {
            return execute(sendDocument);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendDocument(Long chatId, String fileId) {
        return sendDocument(chatId.toString(), fileId);
    }

    public synchronized Message sendDocument(String chatId, Document document, String caption) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setDocument(document.getFileId());
        sendDocument.setCaption(caption);
        sendDocument.setParseMode("MarkdownV2");
        try {
            return execute(sendDocument);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendDocument(Long chatId, Document document, String caption) {
        return sendDocument(chatId.toString(), document, caption);
    }

    public synchronized Message sendDocument(String chatId, String fileId, String caption) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setDocument(fileId);
        sendDocument.setCaption(caption);
        sendDocument.setParseMode("MarkdownV2");
        try {
            return execute(sendDocument);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendDocument(Long chatId, String fileId, String caption) {
        return sendDocument(chatId.toString(), fileId, caption);
    }

    // animation

    public synchronized Message sendAnimation(String chatId, Animation animation) {
        SendAnimation sendAnimation = new SendAnimation();
        sendAnimation.setChatId(chatId);
        sendAnimation.setAnimation(animation.getFileId());
        try {
            return execute(sendAnimation);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendAnimation(Long chatId, Animation animation) {
        return sendAnimation(chatId.toString(), animation);
    }

    public synchronized Message sendAnimation(String chatId, Animation animation, String caption) {
        SendAnimation sendAnimation = new SendAnimation();
        sendAnimation.setChatId(chatId);
        sendAnimation.setCaption(caption);
        sendAnimation.setParseMode("MarkdownV2");
        sendAnimation.setAnimation(animation.getFileId());
        try {
            return execute(sendAnimation);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendAnimation(Long chatId, Animation animation, String caption) {
        return sendAnimation(chatId.toString(), animation, caption);
    }

    // send chat action

    public synchronized Boolean sendChatAction(Long chatId, ActionType actionType) {
        return sendChatAction(chatId.toString(), actionType);
    }

    public synchronized Boolean sendChatAction(String chatId, ActionType actionType) {
        SendChatAction sendChatAction = new SendChatAction();

        sendChatAction.setChatId(chatId);
        sendChatAction.setAction(actionType);

        try {
            return execute(sendChatAction);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return false;
    }

    // string and keyboard

    public synchronized Message sendStringAndKeyboard(String chatId, String text, List<KeyboardRow> keyboard) {
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setChatId(chatId);
        sendMessage.enableMarkdown(true);
        sendMessage.setText(text);

        replyKeyboardMarkup.setSelective(false);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setKeyboard(keyboard);
        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendStringAndKeyboard(Long chatId, String text, List<KeyboardRow> keyboard) {
        return sendStringAndKeyboard(chatId.toString(), text, keyboard);
    }

    public synchronized Message sendStringAndRemoveKeyboard(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);
        sendMessage.enableMarkdown(true);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(new ReplyKeyboardRemove());

        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendStringAndRemoveKeyboard(Long chatId, String text) {
        return sendStringAndRemoveKeyboard(chatId.toString(), text);
    }

    public synchronized Message sendStringAndKeyboard(String chatId, String text, List<KeyboardRow> keyboard, boolean oneTimeKeyboard) {
        SendMessage sendMessage = new SendMessage();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        replyKeyboardMarkup.setSelective(false);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(oneTimeKeyboard);
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setChatId(chatId);
        sendMessage.enableMarkdown(true);
        sendMessage.setText(text);
        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendStringAndKeyboard(Long chatId, String text, List<KeyboardRow> keyboard, boolean oneTimeKeyboard) {
        return sendStringAndKeyboard(chatId.toString(), text, keyboard, oneTimeKeyboard);
    }

    // string and inline keyboard

    public synchronized Message sendStringAndInlineKeyboard(String chatId, String text, List<List<InlineKeyboardButton>> keyboard) {
        SendMessage sendMessage = new SendMessage();
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        inlineKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        sendMessage.setChatId(chatId);
        sendMessage.enableMarkdown(true);
        sendMessage.setText(text);
        try {
            return execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Message sendStringAndInlineKeyboard(Long chatId, String text, List<List<InlineKeyboardButton>> keyboard) {
        return sendStringAndInlineKeyboard(chatId.toString(), text, keyboard);
    }

    // editing

    // string
    public synchronized Serializable editMessageText(String chatId, Integer messageId, String text) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);
        editMessageText.setText(text);
        editMessageText.enableMarkdown(true);
        try {
            return execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable editMessageText(Long chatId, Integer messageId, String text) {
        return editMessageText(chatId.toString(), messageId, text);
    }

    public synchronized Serializable editMessageText(String chatId, Integer messageId, String text, boolean enableMarkdown) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);
        editMessageText.setText(text);
        editMessageText.enableMarkdown(enableMarkdown);
        try {
            return execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable editMessageText(Long chatId, Integer messageId, String text, boolean enableMarkdown) {
        return editMessageText(chatId.toString(), messageId, text, enableMarkdown);
    }

    // inline keyboard
    public synchronized Serializable editMessageInlineKeyboard(String chatId, Integer messageId, List<List<InlineKeyboardButton>> keyboard) {
        EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
        editMessageReplyMarkup.setReplyMarkup(new InlineKeyboardMarkup().setKeyboard(keyboard));
        editMessageReplyMarkup.setChatId(chatId);
        editMessageReplyMarkup.setMessageId(messageId);
        try {
            return execute(editMessageReplyMarkup);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable editMessageInlineKeyboard(Long chatId, Integer messageId, List<List<InlineKeyboardButton>> keyboard) {
        return editMessageInlineKeyboard(chatId.toString(), messageId, keyboard);
    }

    // string and inline keyboard
    public synchronized Serializable editMessageTextAndInlineKeyboard(String chatId, Integer messageId, String text, List<List<InlineKeyboardButton>> keyboard) {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);
        editMessageText.setText(text);
        editMessageText.enableMarkdown(true);
        editMessageText.setReplyMarkup(new InlineKeyboardMarkup().setKeyboard(keyboard));
        try {
            return execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable editMessageTextAndInlineKeyboard(Long chatId, Integer messageId, String text, List<List<InlineKeyboardButton>> keyboard) {
        return editMessageTextAndInlineKeyboard(chatId.toString(), messageId, text, keyboard);
    }

    public synchronized Serializable editMessageTextAndInlineKeyboard(String chatId, Integer messageId, String text, List<List<InlineKeyboardButton>> keyboard, String parseMode) {
        EditMessageText editMessageText = new EditMessageText();

        editMessageText.setChatId(chatId);
        editMessageText.setMessageId(messageId);
        editMessageText.setText(text);
        editMessageText.setParseMode(parseMode);
        editMessageText.setReplyMarkup(new InlineKeyboardMarkup().setKeyboard(keyboard));

        try {
            return execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable editMessageTextAndInlineKeyboard(Long chatId, Integer messageId, String text, List<List<InlineKeyboardButton>> keyboard, String parseMode) {
        return editMessageTextAndInlineKeyboard(chatId.toString(), messageId, text, keyboard, parseMode);
    }

    // photo
    public synchronized Serializable editMessagePhotoAndCaption(String chatId, Integer messageId, String caption, String fileId) {
        InputMediaPhoto inputMedia = new InputMediaPhoto();
        EditMessageMedia editMessageMedia = new EditMessageMedia();

        inputMedia.setCaption(caption);
        inputMedia.setParseMode("MarkdownV2");
        inputMedia.setMedia(fileId);

        editMessageMedia.setChatId(chatId);
        editMessageMedia.setMessageId(messageId);
        editMessageMedia.setMedia(inputMedia);

        try {
            return execute(editMessageMedia);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable editMessagePhotoAndCaption(Long chatId, Integer messageId, String caption, String fileId) {
        return editMessagePhotoAndCaption(chatId.toString(), messageId, caption, fileId);
    }

    // deleting

    public synchronized Serializable deleteMessage(String chatId, Integer messageId) {
        DeleteMessage deleteMessage = new DeleteMessage();

        deleteMessage.setChatId(chatId);
        deleteMessage.setMessageId(messageId);

        try {
            return execute(deleteMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable deleteMessage(Long chatId, Integer messageId) {
        return deleteMessage(chatId.toString(), messageId);
    }

    // kicking chat member

    public synchronized Serializable kickChatMember(Integer userId, String chatId) {
        KickChatMember kickChatMember = new KickChatMember();
        kickChatMember.setUserId(userId);
        kickChatMember.setChatId(chatId);
        try {
            return execute(kickChatMember);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable kickChatMember(Integer userId, Long chatId) {
        return kickChatMember(userId, chatId.toString());
    }

    // leaving chat

    public synchronized Serializable leaveChat(String chatId) {
        LeaveChat leaveChat = new LeaveChat();
        leaveChat.setChatId(chatId);
        try {
            return execute(leaveChat);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable leaveChat(Long chatId) {
        return leaveChat(chatId.toString());
    }

    // inline mode

    public synchronized Serializable answerInlineQuery(String id, List<InlineQueryResult> results) {
        AnswerInlineQuery answerInlineQuery = new AnswerInlineQuery();

        answerInlineQuery.setInlineQueryId(id);
        answerInlineQuery.setResults(results);

        try {
            return execute(answerInlineQuery);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Serializable answerInlineQuery(String id, InlineQueryResult... results) {
        return answerInlineQuery(id, Arrays.asList(results));
    }

    // token

    public String getBotToken() {
        return TOKEN;
    }
}

