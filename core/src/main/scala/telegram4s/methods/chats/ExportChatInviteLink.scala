package telegram4s.methods.chats

import io.circe._
import io.circe.generic.semiauto._
import telegram4s.methods.TelegramMethod
import telegram4s.models.ChatId

/**
 * Use this method to export an invite link to a supergroup or a channel.
 * The bot must be an administrator in the chat for this to work and
 * must have the appropriate admin rights.
 *
 * '''Note''':
 * Each administrator in a chat generates their own invite links.
 * Bots can't use invite links generated by other administrators.
 * If you want your bot to work with invite links,
 * it will need to generate its own link using exportChatInviteLink –
 * after this the link will become available to the bot via the getChat method.
 *
 * If your bot needs to generate a new invite link replacing its previous one,
 * use exportChatInviteLink again.
 *
 * Returns exported invite link as String on success.
 *
 * @param chatId Unique identifier for the target chat or username of the target channel
 *               (in the format @channelusername)
 */
final case class ExportChatInviteLink(chatId: ChatId)

object ExportChatInviteLink {
  implicit val encoder: Encoder[ExportChatInviteLink] = deriveEncoder[ExportChatInviteLink]
  implicit val method: TelegramMethod[ExportChatInviteLink, String] = TelegramMethod[ExportChatInviteLink, String]("ExportChatInviteLink")
}
