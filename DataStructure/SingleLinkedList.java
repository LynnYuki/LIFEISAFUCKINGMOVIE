/**
 * 单链表的实现
 */

 class HeroNode {
     public int no ;
     public String name;
     public String nickName;
     //指向下一个节点
     public HeroNode next;

     public HeroNode (int no,String name,String nickName) {
         this.no = no;
         this.name = name;
         this.nickName nickName;
     }
     
     @Override 
     public String toString () {
         return "HeroNode [no=" + no +",name=" + name+",nickName=" + nickName +"]";
     }

    class SingleLinkedList {
        //头节点
        private HeroNode head = new HeroNode(0,"","");

        //添加节点 不考虑编号顺序
        //找到当前链表的最后节点将其next 指向新的节点
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
        }

        //顺序添加
        public void addByOrder(HeroNode heroNode) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                //到末尾了 
                if (temp.next == null) {
                    break;
                }
                //找到插入位置
                if (temp.next.no > heroNode.no) {
                    break;
                //已存在节点
                } else if (temp.next.no == heroNode.no) {
                    flag = true;
                    break;
                }
                //后移
                temp = temp.next;
            }

            if (flag) {
                System.out.printf("节点%d已经存在不能添加。\n",heroNode.no);
            } else {
                //插入
                heroNode.next = temp.next;
                temp.next = heroNode;
            }

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
        //找到待删除节点的前一个节点
        public void delete (int no) {
            HeroNode temp = head;
            boolean flag = false;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                if (temp.next.no == no) {
                    false = true;
                    break;
                }
                temp = temp.next;
            }
            if (flag) {
                temp.next = temp.next.next;
            } else {
                System.out.printf("要删除的%d节点不存在\n",no);
            }
        }
    }
 }