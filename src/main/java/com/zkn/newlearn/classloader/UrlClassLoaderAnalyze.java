package com.zkn.newlearn.classloader;

/**
 * Created by wb-zhangkenan on 2017/1/3.
 */
public class UrlClassLoaderAnalyze {
    /**
     * public URLClassLoader(URL[] urls):
     *  这里的urls是一个java.net.URL的对象数组，这些对象指向了加载类时候查找的位置。任何以/结尾的URL都假设是一个目录。
     *  否则，认为它是一个jar文件，必要时会将它下载并解压。
     *  在servlet容器中，查找servlet类的位置称为repository(仓库)。
     * public URL(URL context, java.lang.String spec, URLStreamHandler hander)
     *  你可以使用这个构造方法，并为第二个参数传递一个说明，为第一个和第三个参数都传递null
     * public URL(java.lang.String protocol, java.lang.String host, java.lang.String file)
     *  protocol:要用的协议（支持的协议：http、https、ftp、file 和 jar）
     *  host - 主机名称。
     *  file - 主机上的文件
     *
     */

}
