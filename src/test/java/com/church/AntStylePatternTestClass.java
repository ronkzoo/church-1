package com.church;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by LeeRyu on 2015-07-23.
 * com.church
 */
public class AntStylePatternTestClass {

/*    ? : 1개의 문자와 매칭 (matches single character)
    * : 0개 이상의 문자와 매칭 (matches zero or more characters)
    ** : 0개 이상의 디렉토리와 파일 매칭 (matches all files / directories)*/

    @Test
    public void test() {
        // double asterisks
        assertThat(true, is(checkAntPattern("/static/**", "/static/a.jpg")));
        assertThat(true, is(checkAntPattern("/static/**", "/static/css/a.css")));
        assertThat(true, is(checkAntPattern("/static/**", "/static/js/a.js")));
        assertThat(true, is(checkAntPattern("/static/**", "/static/img/a.jpg")));
        assertThat(true, is(checkAntPattern("/static/**", "/static/a/b/c/d/e/f/g/a.jpg")));
        assertThat(true, is(checkAntPattern("/static/**", "/static")));
        assertThat(true, is(checkAntPattern("/static/**", "/static")));


        // single asterisks
        assertThat(true, is(checkAntPattern("/static/*", "/static/a.jpg")));
        assertThat(true, is(checkAntPattern("/static/*", "/static/namkyuProfilePicture.jpg")));
        assertThat(false, is(checkAntPattern("/static/*", "/static/a/sql.jpg")));
        assertThat(false, is(checkAntPattern("/static/*", "/static/a/b/c/d/sql.jpg")));
        assertThat(true, is(checkAntPattern("/static*/*", "/static/sql.jpg")));
        assertThat(true, is(checkAntPattern("/static*/*", "/static1/sql.jpg")));
        assertThat(true, is(checkAntPattern("/static*/*", "/static123/sql.jpg")));
        assertThat(true, is(checkAntPattern("/static*/*", "/static-123/sql.jpg")));
        assertThat(true, is(checkAntPattern("/static*/*", "/static~!@#$%^&*()_+}{|/sql.jpg")));
        assertThat(false, is(checkAntPattern("/static*/*", "/static12/a/sql.jpg")));
        assertThat(false, is(checkAntPattern("/static*/*", "/static12/a/b/sql.jpg")));

        assertThat(true, is(checkAntPattern("/church/**", "/church/download/boardid/aaa.txt")));

        // question-mark
        assertThat(true, is(checkAntPattern("/static-?/**", "/static-a/a.jpg")));
        assertThat(true, is(checkAntPattern("/static-?/**", "/static-a/b/c/a.jpg")));
        assertThat(true, is(checkAntPattern("/static-?/*", "/static-a/abcd.jpg")));
        assertThat(true, is(checkAntPattern("/static-?/???.jpg", "/static-a/abc.jpg")));
    }

    private boolean checkAntPattern(String pattern, String inputStr) {
        return matches(pattern, inputStr);
    }

    public static boolean matches(String pattern, String inputStr) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        return antPathMatcher.match(pattern, inputStr);
    }
}
