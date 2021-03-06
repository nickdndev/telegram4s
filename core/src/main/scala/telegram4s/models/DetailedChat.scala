package telegram4s.models

import telegram4s.models.ChatType.ChatType
import telegram4s.models.messages.TelegramMessage

final case class DetailedChat(id: Long,
                              `type`: ChatType,
                              title: Option[String],
                              username: Option[String],
                              firstName: Option[String],
                              lastName: Option[String],
                              permissions: Option[ChatPermissions],
                              photo: Option[ChatPhoto],
                              description: Option[String],
                              inviteLink: Option[String],
                              pinnedMessage: Option[TelegramMessage],
                              stickerSetName: Option[String],
                              canSetStickerSet: Option[Boolean])
