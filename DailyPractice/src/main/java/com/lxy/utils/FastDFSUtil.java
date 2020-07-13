package com.lxy.utils;

import com.github.tobato.fastdfs.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class FastDFSUtil {

    private static FastFileStorageClient storageClient;

    private static FdfsWebServer fdfsWebServer;

    @Autowired
    public void setStorageClient(FastFileStorageClient storageClient) {
        FastDFSUtil.storageClient = storageClient;
    }

    @Autowired
    public void setFdfsWebServer(FdfsWebServer fdfsWebServer) {
        FastDFSUtil.fdfsWebServer = fdfsWebServer;
    }

    /**
     * 功能描述: 文件上传(MultipartFile)
     * @param file : 要上传的文件
     * @return : java.lang.String 文件地址
     * @author : zuoxiaobin
     * @date : 2019/1/7 13:57
     */
    public static String uploadFile(MultipartFile file) throws IOException {
        InputStream inputStream = null;
        StorePath storePath;
        try {
            inputStream = file.getInputStream();
            storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return storePath.getFullPath();
    }

    /**
     * 功能描述: 文件上传(File)
     * @param file : 要上传的文件
     * @return : java.lang.String 文件地址
     * @author : zuoxiaobin
     * @date : 2019/1/7 13:57
     */
    public static String uploadFile(File file) throws FileNotFoundException {
        FileInputStream inputStream = null;
        StorePath storePath;
        try {
            inputStream = new FileInputStream(file);
            storePath = storageClient.uploadFile(inputStream, file.length(), FilenameUtils.getExtension(file.getName()), null);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return storePath.getFullPath();
    }

    /**
     * 功能描述: 文件上传(inputStream)
     * @param inputStream : 输入流
     * @param extension : 扩展名(eg:jpg)
     * @return : java.lang.String 文件地址
     * @author : zuoxiaobin
     * @date : 2019/1/10 18:33
     */
    public static String uploadFile(InputStream inputStream, String extension) throws IOException {
        StorePath storePath;
        try {
            storePath = storageClient.uploadFile(inputStream, inputStream.available(), extension, null);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        return storePath.getFullPath();
    }

    /**
     * 功能描述: 获取文件服务器url
     * @return : java.lang.String
     * @author : zuoxiaobin
     * @date : 2019/1/7 14:19
     */
    public static String getWebServerUrl() {
        return fdfsWebServer.getWebServerUrl();
    }

    /**
     * 功能描述: 获取文件请求路径
     * @param storePath : fastDFS存储路径
     * @return : java.lang.String
     * @author : zuoxiaobin
     * @date : 2019/1/7 14:19
     */
    public static String getResAccessUrl(String storePath) {
        if (StringUtils.isBlank(storePath)) {
            return null;
        }
        return fdfsWebServer.getWebServerUrl() + "/" + storePath;
    }

    /**
     * 功能描述: 文件删除
     * @param fileUrl : 文件路径
     * @return : void
     * @author : zuoxiaobin
     * @date : 2019/1/7 14:00
     */
    public static void deleteFile(String fileUrl) {
        if (StringUtils.isBlank(fileUrl)) {
            throw new RuntimeException("文件路径fileUrl不能为空！");
        }
        StorePath storePath = StorePath.praseFromUrl(fileUrl);
        storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
    }

    /**
     * 功能描述: 文件下载
     * @param fileUrl : 文件路径
     * @return : java.io.BufferedInputStream 缓冲流
     * @author : zuoxiaobin
     * @date : 2019/1/24 14:21
     */
    public static BufferedInputStream downloadFile(String fileUrl) {
        return downloadFile(fileUrl, new DownloadCallback<BufferedInputStream>() {
            @Override
            public BufferedInputStream recv(InputStream inputStream) throws IOException {
                return new BufferedInputStream(inputStream);
            }
        });
    }

    /**
     * 功能描述: 文件下载(当需要指定返回值类型时，使用此方法)
     * @param fileUrl : 文件路径
     * @param callback : 回调函数
     * @return : T
     * @author : zuoxiaobin
     * @date : 2019/1/24 14:22
     */
    public static <T> T downloadFile(String fileUrl, DownloadCallback<T> callback) {
        StorePath storePath = StorePath.praseFromUrl(fileUrl);
        return storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), callback);
    }

}