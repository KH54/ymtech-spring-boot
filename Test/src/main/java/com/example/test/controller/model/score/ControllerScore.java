package com.example.test.controller.model.score;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.example.test.controller.model.user.ControllerUser;
import com.example.test.model.Score;

/**
 * User와 Score의 정보를 같이 출력해주기 위한 Score 객체 생성 메소드
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:37:06
 *
 * @Validated : 유효성 검사를 위한 annotation
 *
 * @modified 2021. 10. 24. 오후 9:37:06 || Kyunghun Park || 최초 생성
 *
 */
@Validated
public class ControllerScore extends ControllerUser {
    // 유저 UUID -- PK
    private String uuid;
    // 유저 ID - FK
    @NotBlank(message = "plz correct id(Nonblank, NonEmpty")
    private String userId;

    // 유저 국어, 수학, 영어, 과학, 평균 점수 양수와 최대 3의 길이까지가능(100점)
    @Size(min = 1, message = "plz correct score")
    private int korean = -1;
    @Size(min = 1, message = "plz correct score")
    private int math = -1;
    @Size(min = 1, message = "plz correct score")
    private int english = -1;
    @Size(min = 1, message = "plz correct score")
    private int science = -1;
    @Size(min = 1, message = "plz correct score")
    private int average = -1;

    // 기본 생성자
    public ControllerScore() {

    }

    public ControllerScore(Score score) {
        this.setUuid(score.getUuid());
        this.setId(score.getId());
        this.setPwd(score.getPwd());
        this.setName(score.getName());
        this.setGender(score.getGender());
        this.setAge(score.getAge());
        this.uuid = UUID.randomUUID().toString();
        this.userId = score.getUserId();
        this.korean = score.getKorean();
        this.math = score.getMath();
        this.english = score.getEnglish();
        this.science = score.getScience();
        this.average = score.getAverage();
    }

    /**
     * ControllerScore.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 10:24:57
     *
     * @return 
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * uuid 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 10:24:57
     *
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param id
     */
    public void setUserId(String id) {
        this.userId = id;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getKorean() {
        return korean;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param korean
     */
    public void setKorean(int korean) {
        this.korean = korean;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getMath() {
        return math;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param math
     */
    public void setMath(int math) {
        this.math = math;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getEnglish() {
        return english;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param english
     */
    public void setEnglish(int english) {
        this.english = english;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getScience() {
        return science;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param science
     */
    public void setScience(int science) {
        this.science = science;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getAverage() {
        return average;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param average
     */
    public void setAverage(int average) {
        this.average = average;
    }

}