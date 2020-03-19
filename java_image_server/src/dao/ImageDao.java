package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import common.JavaImageServerException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class ImageDao {
    /**
     * 把image对象插入到数据库中
     * @param image
     */
    public void insert(Image image){
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2.创建并拼装sql
        String sql="insert into image_table values(null,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1,image.getImageName());
            statement.setInt(2,image.getSize());
            statement.setString(3, image.getUploadTime());
            statement.setString(4, image.getContentType());
            statement.setString(5, image.getPath());
            statement.setString(6, image.getMd5());
            //3.执行SQL语句
            int ret = statement.executeUpdate();
            if(ret!=1){
                throw new JavaImageServerException("插入数据库出错！");
                //程序出现问题，抛出一个异常
            }
            //关闭连接和statement对象
            DBUtil.close(connection,statement,null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JavaImageServerException e) {
            e.printStackTrace();
        }
        //4.关闭连接和statement对象

        finally {
            DBUtil.close(connection,statement,null);
        }


    }

    /**
     *
     * @return
     */
    public List<Image> selectAll(){
        List<Image> images = new ArrayList<Image>();
        //1.获取数据库连接
        Connection connection =DBUtil.getConnection();
        //2.构造SQL语句
        String sql ="select * from image_table";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //3.指行SQL语句
        try{
            statement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            //4.处理结果集
            while(resultSet.next()){
                Image image = new Image();
                image.setImageId(resultSet.getInt("imageId"));
                image.setImageName(resultSet.getString("imageName"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime("uploadTime");
                image.setContentType(resultSet.getString("contentType"));
                image.setPath(resultSet.getString("path"));
                image.setMd5(resultSet.getString("md5"));
                images.add(image);
            }
            return images;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            //5.关闭连接
            DBUtil.close(connection,statement,resultSet);
        }
        //如果出现异常返回空就可以了
        return null;
    }

    /**
     * genju ImageId查找指定的图片信息
     * @param imageId
     * @return
     */
    public Image selectOne(int imageId){
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2.构造SQL语句
        String sql ="select * from image_table where imageId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //3.执行SQL语句
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement .setInt(1,imageId);
            resultSet = statement.executeQuery();
            //4.处理结果集
            if (resultSet.next()){
                Image image = new Image();
                image.setImageId(resultSet.getInt("imageId"));
                image.setImageName(resultSet.getString("imageName"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime("uploadTime");
                image.setContentType(resultSet.getString("contentType"));
                image.setPath(resultSet.getString("path"));
                image.setMd5(resultSet.getString("md5"));
                return image;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    /**
     * 根据imageId删除图片
     * @param imageId
     */
    public void delete(int imageId){
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2.构造SQL语句
        String sql ="delete from image_table where imageId = ?";
        PreparedStatement statement = null;
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setInt(1,imageId);
            int ret = statement.executeUpdate();
            //删除一条记录影响一行
            if(ret!=1){
                throw new JavaImageServerException("删除数据库操作失败");
            }
        } catch (JavaImageServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.关闭连接
            DBUtil.close(connection,statement,null);
        }
    }

    public static void main(String[] args) {
        //1.测试插入数据
        /*
        Image image = new Image();
        image.setImageName("1.png");
        image.setSize("100");
        image.setUploadTime("20200216");
        image.setContentType("image/png");
        image.setPath("./data/1.png");
        image.setMd5("11223344");
        ImageDao imageDao = new ImageDao();
        imageDao.insert(image);
        */
        //2.测试查找所有图片信息
        /*
        ImageDao imageDao =new ImageDao();
        List<Image> images = imageDao.selectAll();
        System.out.println(images);
        */
        //3.测试查找制定图片信息
        /*
        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(1);
        System.out.println(image);*/
        //4.测试删除图片
        /*
        ImageDao imageDao = new ImageDao();
        imageDao.delete(1);*/
    }
    public Image selectByMd5(String md5) {
        // 1. 获取数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 构造 SQL 语句
        String sql = "select * from image_table where md5 = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 3. 执行 SQL 语句
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, md5);
            resultSet = statement.executeQuery();
            // 4. 处理结果集
            if (resultSet.next()) {
                Image image = new Image();
                image.setImageId(resultSet.getInt("imageId"));
                image.setImageName(resultSet.getString("imageName"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime(resultSet.getString("uploadTime"));
                image.setContentType(resultSet.getString("contentType"));
                image.setPath(resultSet.getString("path"));
                image.setMd5(resultSet.getString("md5"));
                return image;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭链接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }
}
