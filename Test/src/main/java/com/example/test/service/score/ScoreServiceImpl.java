package com.example.test.service.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.controller.model.score.DeleteRes;
import com.example.test.controller.model.score.ReadRes;
import com.example.test.controller.model.score.UpdateRes;
import com.example.test.custom_exception.NullValueObjectException;
import com.example.test.dao.score.ScoreDao;
import com.example.test.model.Score;
import com.example.test.service.score.impl.IScoreService;

/**
 * 컨트롤러로 부터 받은 데아터를 가공하는 Service
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 7:24:12
 *
 * @modified 2021. 10. 24. 오후 7:24:12 || Kyunghun Park || 최초 생성
 *
 */
@Service("scoreService")
public class ScoreServiceImpl implements IScoreService {

    // scoreDao 주입
    @Autowired
    ScoreDao scoreDao;

    /**
     * @see com.example.test.service.score.impl.IScoreService#getAll()
     */
    @Override
    public List<Score> getAll() {
        return scoreDao.getAll();
    }

    /**
     * @see com.example.test.service.score.impl.IScoreService#getScore(String)
     */
    @Override
    public ReadRes getScore(String id) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        ReadRes res = new ReadRes();
        
        // id를 scoreDao로 전송하여 저장된 정보를 호출
        res.setRead(scoreDao.getScore(id));
        return res;
    }

    /**
     * @see com.example.test.service.score.impl.IScoreService#updateScore(String,
     *      Score)
     */
    @Override
    public UpdateRes updateScore(String id, Score score) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        UpdateRes res = new UpdateRes();
        // 요청한 id가 있는 경우
        if (scoreDao.getScore(id) != null) {

            // 변경하기 전의 Score객체를 저장
            res.setBefore(scoreDao.getScore(id));

            score.setId(id);

            // 변경할 값을 입력 받지 않았다면 Score의 이전 정보를 그대로 저장
            score.setEnglish(score.getEnglish() != 0 ? score.getEnglish() : scoreDao.getScore(id).getEnglish());
            score.setScience(score.getScience() != 0 ? score.getScience() : scoreDao.getScore(id).getScience());
            score.setAverage(score.getAverage() != 0 ? score.getAverage() : scoreDao.getScore(id).getAverage());
            score.setKorean(score.getKorean() != 0 ? score.getKorean() : scoreDao.getScore(id).getKorean());
            score.setMath(score.getMath() != 0 ? score.getMath() : scoreDao.getScore(id).getMath());

            // 해당하는 id의 User의 정보를 저장
            score.setPwd(scoreDao.getScore(id).getPwd());
            score.setName(scoreDao.getScore(id).getName());
            score.setGender(scoreDao.getScore(id).getGender());
            score.setAge(scoreDao.getScore(id).getAge());

            // 변경된 객체를 res에 저장
            res.setAfter(score);
            // 변경된 객체를 dao로 전달
            scoreDao.updateScore(score);
        }
        return res;
    }

    /**
     * @see com.example.test.service.score.impl.IScoreService#deleteScore(String)
     */
    @Override
    public DeleteRes deleteScore(String id) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        DeleteRes res = new DeleteRes();

        // 전달받은 id의 정보를 scoreDao로 전달하여 존재하면 set, 없으면 null로 반환
        res.setDelete(scoreDao.getScore(id) != null ? scoreDao.getScore(id) : null);
        
//        // id의 정보가 DB에 존재하지 않는 경우 null exception
//        if (res.getDeleted() == null) {
//            throw new NullValueObjectException();
//        }
        
        return res;
    }

}
