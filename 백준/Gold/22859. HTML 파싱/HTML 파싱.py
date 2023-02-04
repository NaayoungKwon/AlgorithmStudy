import sys
import re


def solution2(s):
    que = [];
    main = re.findall('<main>(.*)</main>', s)[0];
    for div, para in re.findall('<div title="(.*?)">(.*?)</div>',main):
        # print(div, para);
        que.append('title : ' + div);
        for p in re.findall('<p>(.*?)</p>',para):
            p = re.sub('<[a-z /]*>','',p);
            p= re.sub('^[ ]*|[ ]*$','',p);
            p = re.sub('[ ]+', ' ',p);
            que.append(p);
    for paragraph in que:
        print(paragraph);
s = sys.stdin.readline()[:-1];
solution2(s);