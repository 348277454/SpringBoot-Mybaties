package com.ss.mapper;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Component;

import com.ss.pojo.Student;

import java.util.Set;

@Component
public class GxidResultHandler implements ResultHandler<Student> {
  // 这是每批处理的大小
  private final static int BATCH_SIZE = 10;
  private int size;
  // 存储每批数据的临时容器
  private Set<Student> stus;

  public void handleResult(ResultContext<? extends Student> resultContext) {
    // 这里获取流式查询每次返回的单条结果
	Student gxid = resultContext.getResultObject();
    // 你可以看自己的项目需要分批进行处理或者单个处理，这里以分批处理为例
	if(null != gxid){
		System.out.println(gxid);
		stus.add(gxid);
	    size++;
	    if (size == BATCH_SIZE) {
	    	 size = 0;
	    	 stus.clear();
	    }
	}
  }

  private void handle() {
    try {
      // 在这里可以对你获取到的批量结果数据进行需要的业务处理
    } finally {
      // 处理完每批数据后后将临时清空
      size = 0;
      stus.clear();
    }
  }

/* // 这个方法给外面调用，用来完成最后一批数据处理
  public void end(){
    handle();// 处理最后一批不到BATCH_SIZE的数据
  }*/
}
