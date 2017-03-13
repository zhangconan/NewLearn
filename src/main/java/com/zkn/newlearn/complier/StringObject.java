package com.zkn.newlearn.complier;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/**
 * Created by wb-zhangkenan on 2017/3/8.
 *
 * @author wb-zhangkenan
 * @date 2017/03/08
 */
public class StringObject extends SimpleJavaFileObject {
    private String contents = null;

    public StringObject(String className, String contents) throws Exception {
        super(new URI(className), Kind.SOURCE);
        this.contents = contents;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors)
            throws IOException {
        return contents;
    }
}
