package telegram4s.methods.messages

import io.circe._
import io.circe.generic.auto._
import io.circe.generic.semiauto._
import telegram4s.methods.TelegramMethod
import telegram4s.models.messages.TelegramMessage
import telegram4s.models.{ChatId, InlineKeyboardMarkup}

/**
 * Use this method to edit live location messages sent by the bot or via the bot (for inline bots).
 * A location can be edited until its live_period expires or editing is explicitly disabled by a call to stopMessageLiveLocation.
 *
 * Use methods in companion object in order to construct the value of this class.
 *
 * @param chatId          Unique identifier for the target chat or username of the target channel
 *                        (in the format @channelusername)
 *                        Required if 'inlineMessageId' is not specified.
 * @param messageId       Identifier of the sent message.
 *                        Required if 'inlineMessageId' is not specified.
 * @param inlineMessageId Identifier of the inline message.
 *                        Required if 'chatId' and 'messageId' are not specified.
 * @param latitude        Latitude of new location
 * @param longitude       Longitude of new location
 * @param replyMarkup     Additional interface options.
 *                        A JSON-serialized object for an inline keyboard, custom reply keyboard,
 *                        instructions to hide reply keyboard or to force a reply from the user.
 */
final class EditMessageLiveLocation private(val chatId: Option[ChatId],
                                            val messageId: Option[Int],
                                            val inlineMessageId: Option[Int],
                                            val latitude: Double,
                                            val longitude: Double,
                                            val replyMarkup: Option[InlineKeyboardMarkup])

object EditMessageLiveLocation {
  implicit val encoder: Encoder[EditMessageLiveLocation] = deriveEncoder[EditMessageLiveLocation]
  implicit val method: TelegramMethod[EditMessageLiveLocation, Either[Boolean, TelegramMessage]] =
    TelegramMethod[EditMessageLiveLocation, Either[Boolean, TelegramMessage]]("EditMessageLiveLocation")

  /**
   * For the messages sent directly by the bot
   */
  def direct(chatId: ChatId,
             messageId: Int,
             lat: Double,
             long: Double,
             replyMarkup: Option[InlineKeyboardMarkup] = None): EditMessageLiveLocation =
    new EditMessageLiveLocation(Some(chatId), Some(messageId), None, lat, long, replyMarkup)

  /**
   * For the inlined messages sent via the bot
   */
  def inlined(inlineMessageId: Int,
              lat: Double,
              long: Double,
              replyMarkup: Option[InlineKeyboardMarkup] = None): EditMessageLiveLocation =
    new EditMessageLiveLocation(None, None, Some(inlineMessageId), lat, long, replyMarkup)
}
