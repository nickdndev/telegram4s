package telegram4s.methods.messages

import io.circe._
import io.circe.generic.semiauto._
import telegram4s.methods.TelegramMethod
import telegram4s.models.ChatId

/**
 * Use this method to delete a message.
 *
 * A message can only be deleted if it was sent less than 48 hours ago.
 * Any such recently sent outgoing message may be deleted.
 *
 * Additionally, if the bot is an administrator in a group chat, it can delete any message.
 *
 * If the bot is an administrator in a supergroup, it can delete messages from any other user
 * and service messages about people joining or leaving the group
 * (other types of service messages may only be removed by the group creator).
 *
 * In channels, bots can only remove their own messages.
 *
 * Returns True on success.
 *
 * @param chatId    Unique identifier for the target chat or username of the target channel
 *                  (in the format @channelusername).
 * @param messageId Identifier of the message to delete
 */
final case class DeleteMessage(chatId: ChatId, messageId: Int)

object DeleteMessage {
  implicit val encoder: Encoder[DeleteMessage] = deriveEncoder[DeleteMessage]
  implicit val method: TelegramMethod[DeleteMessage, Boolean] =
    TelegramMethod[DeleteMessage, Boolean]("DeleteMessage")
}
