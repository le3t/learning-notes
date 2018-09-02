package org.ko.spark.log.dao

import java.sql.{Connection, PreparedStatement}

import org.ko.spark.log.MySQLUtils
import org.ko.spark.log.model.DayVideoAccessStat

import scala.collection.mutable.ListBuffer

/**
  * 各个维度统计的DAO操作
  */
object StatDAO {

  /**
    * 批量保存 #DayVideoAccessStat 到数据库
    * @param list
    */
  def insertDayVideoAccessTopN(list: ListBuffer[DayVideoAccessStat]) = {

    var conn: Connection = null
    var statement: PreparedStatement = null

    try {
      conn = MySQLUtils.getConnection()
      conn.setAutoCommit(false) //设置手动提交

      val sql = "INSERT INTO t_day_video_access_topn_stat(day, cms_id, times) values(?, ?, ?)"
      statement = conn.prepareStatement(sql)
      list.foreach(target => {
        statement.setString(1, target.day)
        statement.setLong(2, target.cmsId)
        statement.setLong(3, target.times)

        statement.addBatch()
      })

      statement.executeBatch()  //执行批量处理
      conn.commit() //手动提交

    } catch {
      case e: Exception => e.printStackTrace()
    } finally {
      MySQLUtils.release(conn, statement)
    }
  }
}