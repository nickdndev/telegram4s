package telegram4s.models

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

/**
 * Incoming inline query.
 *
 * When the user sends an empty query, your bot could return some default or trending results.
 *
 * @param id       Unique identifier for this query
 * @param from     Sender
 * @param location Sender location, only for bots that request user location
 * @param query    Text of the query
 * @param offset   Offset of the results to be returned, can be controlled by the bot
 */
final case class InlineQuery(id: String, from: User, location: Option[Location], query: String, offset: String)

object InlineQuery {
  implicit val decoder: Decoder[InlineQuery] = deriveDecoder[InlineQuery]
}
