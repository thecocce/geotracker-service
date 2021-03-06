package services

import com.mohiva.play.silhouette.api.services.IdentityService
import com.mohiva.play.silhouette.impl.providers.CommonSocialProfile
import models.User
import scala.concurrent.Future
import java.util.UUID

trait UserService extends IdentityService[User] {

  def save(user: User): Future[User]

  def save(profile: CommonSocialProfile): Future[User]

  def find(apiKey: UUID): Option[User]

}
