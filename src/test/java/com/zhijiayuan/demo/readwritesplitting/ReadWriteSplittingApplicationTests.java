package com.zhijiayuan.demo.readwritesplitting;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhijiayuan.demo.readwritesplitting.entity.User;
import com.zhijiayuan.demo.readwritesplitting.mapper.UserMapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ReadWriteSplittingApplicationTests {

    @Autowired
    private UserMapper mapper;

    /**
     * 插入自动走主库
     */
    @Test
    public void aInsert() {
        User user = new User();
        user.setName("小羊");
        user.setAge(3);
        user.setEmail("abc@mp.com");
        mapper.insert(user);
    }

    /**
     * 查询自动走从库
     */
    @Test
    public void select() {
        List<User> users = mapper.selectList(new QueryWrapper<>());
        if (users != null) {
            System.out.println(users);
        }
    }

    /**
     * 查询强制走主库
     */
    @Test
    public void selectMaster() {
        try (HintManager hintManager = HintManager.getInstance()) {
            hintManager.setMasterRouteOnly();
            List<User> users = mapper.selectList(new QueryWrapper<>());
            if (users != null) {
                System.out.println(users);
            }
        }
    }

}
