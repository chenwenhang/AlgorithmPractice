import heapq


class Solution:
    # 总的时间复杂度O(nlogn)
    def print_top_ten_user(self, file_name: str):
        # 读取数据
        try:
            with open(file_name, "r") as f:
                data = f.readlines()
                # 去除列头
                lines = data[1:]
        except:
            print("读取文件发生错误，请检查文件名")
            return

        # 定义map
        user_map = {}

        try:
            # 规则化，并构造hashmap
            # 时间复杂度 O(N)
            for line in lines:
                # 去除末尾的换行符
                line = line.strip()
                # 获得user（不需要知道文章）
                user, _ = line.split(",")
                # 构造map
                if user in user_map.keys():
                    user_map.update({user: user_map[user] + 1})
                else:
                    user_map.update({user: 1})

            # map转list，用于后续构造堆
            user_list = list(user_map.items())

            # 构造大顶堆，获取最大的十个元素，并指定排序的key为文章数量
            # 时间复杂度O(nlogn)
            top_ten = heapq.nlargest(10, user_list, key=lambda x: x[1])

            # 输出
            print(top_ten)
        except:
            print("处理过程中发生错误，请检查数据格式是否正确")


sol = Solution()
sol.print_top_ten_user("bbs.txt")
# 使用给出的样例txt，获取到的示例输出
# [('A', 6), ('B', 3), ('C', 3), ('E', 2), ('D', 2), ('F', 1), ('G', 1), ('H', 1), ('I', 1), ('J', 1)]
