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
 *
 */
@Service("scoreService")
public class ScoreServiceImpl implements IScoreService {

    // scoreDao 주입
    @Autowired
    private ScoreDao scoreDao;

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
        // 사용자의 요청에 대한 응답을 담기 위한 Response 객체
        ReadScoreRes res = new ReadScoreRes();
        // 사용자의 요청을 담기 위한 Request 객체
        ReadScoreReq req = new ReadScoreReq(id);

        // GET의 결과를 Score 객체에 저장
        ControllerScore score = new ControllerScore(scoreDao.getScore(req));

        // Response에 GET 결과를 저장
        res.setRead(score);

        return res;
    }

    /**
     * @see com.example.test.service.score.impl.IScoreService#updateScore(String,
     *      Score)
     */
    @Override
    public UpdateScoreRes updateScore(String id, Score score) {

        // 유저의 id를 score 객체에 저장
        score.setId(id);

        // 사용자의 요청에 대한 응답을 담기 위한 객체
        UpdateScoreRes res = new UpdateScoreRes();

        // 변경하기 전의 정보로 DAO에 접근 하기 위한 Request
        ReadScoreReq readReq = new ReadScoreReq(score);

        // 변경 후의 정보로 DAO에 접근 하기 위한 Request
        UpdateScoreReq req = new UpdateScoreReq(score);

        // 변경하기 전의 Score객체를 저장
        res.setBefore(scoreDao.getScore(readReq));

        // 변경할 값을 입력 받지 않았다면 Score의 이전 정보를 그대로 저장
        score.setEnglish(score.getEnglish() != -1 ? score.getEnglish() : res.getBefore().getEnglish());
        score.setScience(score.getScience() != -1 ? score.getScience() : res.getBefore().getScience());
        score.setAverage(score.getAverage() != -1 ? score.getAverage() : res.getBefore().getAverage());
        score.setKorean(score.getKorean() != -1 ? score.getKorean() : res.getBefore().getKorean());
        score.setMath(score.getMath() != -1 ? score.getMath() : res.getBefore().getMath());

        // 해당하는 id의 User의 정보를 저장
        score.setPwd(res.getBefore().getId());
        score.setName(res.getBefore().getName());
        score.setGender(res.getBefore().getGender());
        score.setAge(res.getBefore().getAge());

        // 입력받은 정보를 DAO에 접근 하기 위한 Request로 변환
        req.setUpdate(score);

        // DAO에 업데이트 작업 요청
        if (scoreDao.updateScore(req) > 0) {

            // 완료된 작업을 Response로 변환
            res.setAfter(score);
        }
        return res;
    }
}
