package com.qianya.model.out;

import java.io.Serializable;
import java.util.List;

/**
 * 自动回复输出类
 */
public class ReplyDtoOut  implements Serializable {

    private static final long serialVersionUID = -3525535857333236642L;
    private ReplyConfigDtoOut replyConfigDtoOut;


    private List<ReplyConfigDetailDtoOut> replyConfigDetailDtoOuts;

    public ReplyConfigDtoOut getReplyConfigDtoOut() {
        return replyConfigDtoOut;
    }

    public void setReplyConfigDtoOut(ReplyConfigDtoOut replyConfigDtoOut) {
        this.replyConfigDtoOut = replyConfigDtoOut;
    }

    public List<ReplyConfigDetailDtoOut> getReplyConfigDetailDtoOuts() {
        return replyConfigDetailDtoOuts;
    }

    public void setReplyConfigDetailDtoOuts(List<ReplyConfigDetailDtoOut> replyConfigDetailDtoOuts) {
        this.replyConfigDetailDtoOuts = replyConfigDetailDtoOuts;
    }
}
