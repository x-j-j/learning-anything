package com.xjjlearning.apache.dubbo.sample.adaptive;

import com.xjjlearning.apache.dubbo.sample.adaptive.fruit.Apple;
import com.xjjlearning.apache.dubbo.sample.adaptive.fruit.iface.Fruit;
import com.xjjlearning.apache.dubbo.sample.adaptive.iface.FruitGranter;
import org.apache.dubbo.common.URL;

public class AppleGranter implements FruitGranter {
    @Override
    public Fruit grant() {
        return new Apple();
    }

    @Override
    public String watering(URL url) {
        System.out.println("watering apple");
        return "watering success";
    }
}
