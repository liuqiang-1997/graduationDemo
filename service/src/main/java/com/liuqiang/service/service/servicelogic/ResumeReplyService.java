package com.liuqiang.service.service.servicelogic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.liuqiang.model.bo.servicelogic.ResumeReplyBo;
import com.liuqiang.model.entity.servicelogic.ResumeReply;
import com.liuqiang.model.vo.servicelogic.ResumeReplyVo;
import com.liuqiang.model.vo.sys.QueryVo;

/**简历回复信息
 * @author liuqiang
 */
public interface ResumeReplyService extends IService<ResumeReply> {
    ResumeReplyBo queryResumeReply(String resumeUser);

    Boolean insertResumeReply(ResumeReplyVo resumeReplyVo);

    PageInfo<ResumeReplyBo> search(QueryVo queryVo, String resumeUser);
}

