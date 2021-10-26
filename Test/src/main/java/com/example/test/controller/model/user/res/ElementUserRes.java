package com.example.test.controller.model.user.res;

import com.example.test.model.User;

/**
 * 부분 조회 정보를 담기 위한 Response 클래스
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:55:28
 *
 * @modified 2021. 10. 24. 오후 9:55:28 || Kyunghun Park || 최초 생성
 *
 */
public class ElementUserRes {

    private User element;

    // 기본 생성자
    public ElementUserRes() {

    }

    /**
     * element을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오후 3:46:51
     * @return element
     */
    public User getElement() {
        return element;
    }

    /**
     * element을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오후 3:46:51
     * @param element
     */
    public void setElement(User element) {
        this.element = element;
    }

}
