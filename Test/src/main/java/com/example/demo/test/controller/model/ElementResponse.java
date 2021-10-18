package com.example.demo.test.controller.model;

import com.example.demo.test.model.User;

public class ElementResponse {
    private User element;

    public ElementResponse() {

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
