

class HeroNode {
     public int no ;
     public String name;
     public String nickName;
     //指向后继节点
     public HeroNode next;
     //指向前驱节点
     public HeroNode pre;

     public HeroNode (int no,String name,String nickName) {
         this.no = no;
         this.name = name;
         this.nickName nickName;
     }
     
     @Override 
     public String toString () {
         return "HeroNode [no=" + no +",name=" + name+",nickName=" + nickName +"]";
     }
}   

class DoubleLinkedList {
//头节点
    private HeroNode head = new HeroNode(0,"","");
     //返回头结点
    public HeroNode getHead() {
            return head;
    }

     //显示链表,遍历
    public void list() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            //打印节点信息
            System.out.println(temp);
            //temp后移
            temp = temp.next;
        }
    }

    public void add (HeroNode heroNode) {
            //头结点不能动 使用辅助指针
            HeroNode temp = head;
            while (true) {
                //如果数链表的最后一个节点
                if (temp.next == null) {
                    break;
                }
                //如皋没有找到最后,temp后移
                temp = temp.next;
            }
            //退出while循环时,temp指向链表最后
            temp.next = heroNode;
            heroNode.pre = temp;
        }

    //修改除No以外的属性
    public void update (HeroNode heroNode) {
        //判断是否为空
        if (haed.next == null) {
            System.out.println("链表为空")：
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        //遍历链表
        while (true) {
            if (temp == null) {
                break;
            }
            //找到
            if( temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n",heroNode.no);
        }
    }

    //删除节点
    //对于双向链表可以直接删除需要删除的节点不需要寻找前驱节点
    public void delete (int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                false = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.prev.next = temp.next;
            //如果删除的数最后一个节点 则不需要执行下列代码
            if (temp.next != nul){ 
                temp.next.pre = temp.pre;
            }       
        } else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
}
