package com.bravo.pattern.builder.stepbuilder.demo.batchresult;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 测试BatchResult
 * 设计思路请移步至：
 * - 小册 设计模式那些事儿 的《旁边工位的同事，特别爱用设计模式》
 * - 知乎 bravo1988 《旁边工位的同事，特别爱用设计模式》
 */
public class Client {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1L, "张三"),
                new Student(2L, "李四"),
                new Student(3L, "王五")
        );
        String tag = "《设计模式那些事儿》的读者";

        Client client = new Client();
        BatchResult<Student> result = client.batchAttachTagForStudent(students, tag);
        System.out.println("是否全部成功：" + result.isAllCompleted());
        System.out.println(JSON.toJSONString(result));

        // 假设需要通过RPC暴露当前方法，而RPC的返回值是StudentDTO，可以使用内置的convert进行转换
        BatchResult<StudentDTO> rpcResult = result.convert(student -> new StudentDTO(student.getId()));
        System.out.println(JSON.toJSONString(rpcResult));
    }

    /**
     * 为用户批量打标
     */
    private BatchResult<Student> batchAttachTagForStudent(List<Student> students, String tag) {
        if (CollUtil.isEmpty(students) && StrUtil.isBlank(tag)) {
            throw new IllegalArgumentException("参数错误");
        }

        List<Student> completedStudents = new ArrayList<>(students.size());
        for (Student student : students) {
            if (!this.attachTag(student, tag)) {
                // 批量操作中断
                return BatchResult.builder(Student.class)
                        .interrupted()
                        .reason(1001, "打标失败")
                        .result(students.size(), completedStudents)
                        .build();
            }
            completedStudents.add(student);
        }
        // 批量操作成功
        return BatchResult.builder(Student.class)
                .finished()
                .result(students.size(), completedStudents)
                .build();
    }

    private boolean attachTag(Student student, String tag) {
        return ThreadLocalRandom.current().nextInt(10) > 3;
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
