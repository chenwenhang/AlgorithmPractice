package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Wenhang Chen
 * @Description:实现一个可以存储猫和狗的队列，其中poll相关操作需要将指定类型按序弹出
 * @Date: Created in 15:31 10/29/2019
 * @Modified by:
 */
public class DogCatQueue {
    private Queue<PetItem> dogQ;
    private Queue<PetItem> catQ;
    // 用count记录先后次序，新建类PetItem，存储时
    // 将pet和count作为一个整体一并存入队列
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetItem>();
        this.catQ = new LinkedList<PetItem>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQ.add(new PetItem(pet, this.count++));
        } else if (pet.getType().equals("cat")) {
            this.catQ.add(new PetItem(pet, this.count++));
        } else {
            throw new RuntimeException("Error, not cat or dog");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("Error, queue is empty");
        }
    }

    public Dog pollDog() {
        if (!this.dogQ.isEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("DogQueue is empty");
        }
    }

    public Cat pollCat() {
        if (!this.catQ.isEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("CatQueue is empty");
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

}

class PetItem {
    private Pet pet;
    private long count;

    public PetItem(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getPetItemType() {
        return this.pet.getType();
    }
}

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}