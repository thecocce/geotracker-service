package services.impl

import com.mohiva.play.silhouette.api.services.IdentityService
import com.mohiva.play.silhouette.impl.providers.CommonSocialProfile
import scala.concurrent.Future
import javax.inject.Inject
import models.GeoCoord
import models.daos.GeoCoordDao
import services.GeoCoordService
import java.util.UUID
import models.User
import models.NamedLocation
import org.joda.time.Interval

class GeoCoordServiceImpl @Inject() (geoCoordDao: GeoCoordDao) extends GeoCoordService {

  def save(geoCoord: GeoCoord, apiKey: UUID): GeoCoord = {
    geoCoordDao.save(geoCoord, apiKey)
  }

  def save(geoCoords: Seq[GeoCoord], apiKey: UUID) {
    geoCoords.map { c => geoCoordDao.save(c, apiKey) }
  }

  def load(user: User): List[GeoCoord] = {
    geoCoordDao.load(user)
  }

  def loadLatest(apiKey: UUID): Option[GeoCoord] = {
    geoCoordDao.loadLatest(apiKey)
  }

  override def findMatchingCoordinates(user: User, location: NamedLocation, interval: Interval): List[GeoCoord] = {
    geoCoordDao.findMatchingCoordinates(user, location, interval)
  }

}
