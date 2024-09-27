package com.bravo.pattern.builder.stepbuilder.demo.batchresult_v2;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BatchResultTest {

    @Test
    public void test() {
        List<Student> students = Arrays.asList(
                new Student(1L, "张三"),
                new Student(2L, "李四"),
                new Student(3L, "王五"));
        // String tag = "《设计模式那些事儿》的读者";
        String tag = "";

        BatchResult<Student> result = this.batchAttachTagForStudent(students, tag);
        System.out.println("是否调用成功：" + result.isSuccess());
        if (result.isSuccess()) {
            System.out.println("是否全部执行完毕：" + result.getData().isAllCompleted());
            System.out.println("结果：" + JSON.toJSONString(result));

            // 假设需要通过RPC暴露当前方法，而RPC的返回值是StudentDTO，可以使用内置的convert进行转换
            BatchResult<StudentDTO> rpcResult = result.convert(student -> new StudentDTO(student.getId()));
            System.out.println("转换：" + JSON.toJSONString(rpcResult));
        } else {
            System.out.println(JSON.toJSONString(result));
        }
    }

    /**
     * 为用户批量打标
     */
    private BatchResult<Student> batchAttachTagForStudent(List<Student> students, String tag) {
        if (CollUtil.isEmpty(students) || StrUtil.isBlank(tag)) {
            return BatchResult.failed("参数错误");
        }

        List<Student> completedStudents = new ArrayList<>(students.size());
        for (Student student : students) {
            if (!this.attachTag(student, tag)) {
                // 批量操作中断
                return BatchResult.interrupted(Student.class)
                        .reason(1001, "原因")
                        .result(students.size(), completedStudents)
                        .end();
            }
            completedStudents.add(student);
        }
        // 批量操作成功
        return BatchResult.finished(Student.class)
                .result(students.size(), completedStudents)
                .end();
    }

    private boolean attachTag(Student student, String tag) {
        return ThreadLocalRandom.current().nextInt(10) > 2;
    }

    @Data
    @AllArgsConstructor
    static class Student {
        private Long id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class StudentDTO {
        private Long id;
    }
}

