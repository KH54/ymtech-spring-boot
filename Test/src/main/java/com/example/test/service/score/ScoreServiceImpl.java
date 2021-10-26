package com.example.test.service.score;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.controller.model.score.req.ReadScoreReq;
import com.example.test.controller.model.score.req.UpdateScoreReq;
import com.example.test.controller.model.score.res.ReadScoreRes;
import com.example.test.controller.model.score.res.UpdateScoreRes;
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
        List<Score> list = scoreDao.getAll();
        return new ArrayList<>(list);
    }

    /**
     * @see com.example.test.service.score.impl.IScoreService#getScore(String)
     */
    @Override
    public ReadScoreRes getScore(String id) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        ReadScoreRes res = new ReadScoreRes();
        ReadScoreReq req = new ReadScoreReq(id);

        ControllerScore score = new ControllerScore(scoreDao.getScore(req));

        // id를 scoreDao로 전송하여 저장된 정보를 호출
        res.setRead(score);
        return res;
    }

    /**
     * @see com.example.test.service.score.impl.IScoreService#updateScore(String,
     *      Score)
     */
    @Override
    public UpdateScoreRes updateScore(String id, Score score) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        UpdateScoreRes res = new UpdateScoreRes();

        score.setId(id);
        ReadScoreReq readReq = new ReadScoreReq(id);
        UpdateScoreReq req = new UpdateScoreReq(score);

        // 요청한 id가 있는 경우

        // 변경하기 전의 Score객체를 저장
        res.setBefore(scoreDao.getScore(readReq));

        // 변경할 값을 입력 받지 않았다면 Score의 이전 정보를 그대로 저장
        score.setEnglish(score.getEnglish() != 0 ? score.getEnglish() : res.getBefore().getEnglish());
        score.setScience(score.getScience() != 0 ? score.getScience() : res.getBefore().getScience());
        score.setAverage(score.getAverage() != 0 ? score.getAverage() : res.getBefore().getAverage());
        score.setKorean(score.getKorean() != 0 ? score.getKorean() : res.getBefore().getKorean());
        score.setMath(score.getMath() != 0 ? score.getMath() : res.getBefore().getMath());

        // 해당하는 id의 User의 정보를 저장
        score.setPwd(res.getBefore().getId());
        score.setName(res.getBefore().getName());
        score.setGender(res.getBefore().getGender());
        score.setAge(res.getBefore().getAge());
        
        req.setUpdate(score);
        scoreDao.updateScore(req);
        // 변경된 객체를 res에 저장
        res.setAfter(score);
        // 변경된 객체를 dao로 전달

        return res;
    }
}
