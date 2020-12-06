package aoc.solutions.day6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author in-rahul.khandelwal
 */
public class Solution {

    public static void main(String[] args) {
        part2_commonPositive();
    }

    private static void part1_totalPositive() {
        long total = groupStream()
                .map(i -> i.replace("\n", ""))
                .mapToLong(i -> i.chars().distinct().count())
                .sum();

        System.out.println(total);
    }

    private static void part2_commonPositive() {
        long total = groupStream()
                .mapToInt(group -> {
                    String[] people = group.split("\n");
                    List<Integer> c = people[0].chars().boxed().collect(Collectors.toList());
                    for (int i = 1 ; i < people.length ; i++) {
                        c.retainAll(people[i].chars().boxed().collect(Collectors.toList()));
                    }
                    return c.size();
                })
                .sum();

        System.out.println(total);
    }

    private static Stream<String> groupStream() {
        String inputStr = "heqznia\n" +
"cipkn\n" +
"gvsitwynrxb\n" +
"\n" +
"auz\n" +
"zaeu\n" +
"uaz\n" +
"zau\n" +
"zua\n" +
"\n" +
"ctqaibd\n" +
"tbqlzaywvd\n" +
"bqdtcazls\n" +
"qtrdvab\n" +
"hpbtadq\n" +
"\n" +
"e\n" +
"e\n" +
"je\n" +
"e\n" +
"e\n" +
"\n" +
"ilzuqnjhrceay\n" +
"jakzylrnuqcih\n" +
"uhyqijldrzwnac\n" +
"\n" +
"lxtwyiuqerd\n" +
"sfdmpjawvolkbzqnih\n" +
"ldtiewgq\n" +
"\n" +
"absdepjhctyfzxnivom\n" +
"fdvbjnsolpztgywmaihx\n" +
"tkashzxmjbydivfnrop\n" +
"ptnsojahvxmbdzfiy\n" +
"\n" +
"hd\n" +
"dh\n" +
"hd\n" +
"dh\n" +
"\n" +
"bup\n" +
"ktul\n" +
"\n" +
"rjfzdhowqnystc\n" +
"ubfkxhagiqmvplw\n" +
"\n" +
"cvknztpwls\n" +
"cvxtwlq\n" +
"tcvwxl\n" +
"\n" +
"gnusktbacrxodwiyjmzpfhv\n" +
"dipokyjubnhfsmzxtwga\n" +
"\n" +
"lcitb\n" +
"ctli\n" +
"cilt\n" +
"ictl\n" +
"ilct\n" +
"\n" +
"gwpctaiv\n" +
"fgqvptawch\n" +
"pglictavw\n" +
"\n" +
"olsamdbycu\n" +
"yhbdascjuo\n" +
"osaytbi\n" +
"\n" +
"pwhboyvqnf\n" +
"bwfqvnymipodch\n" +
"fjpoywbxvlqhn\n" +
"nqwfybpohv\n" +
"\n" +
"ghwyxuedk\n" +
"rjnf\n" +
"vstzqpbila\n" +
"\n" +
"tgrhwndx\n" +
"rwgtdxhn\n" +
"\n" +
"spzuibywxmgtcaefhd\n" +
"tsaumexhwfyigbpcdz\n" +
"\n" +
"fagpleck\n" +
"uhm\n" +
"\n" +
"dgfxejy\n" +
"vxdjg\n" +
"wjdxg\n" +
"\n" +
"snwlrgahefdvpimqzukbty\n" +
"awkpifsbutnqlegvmzrdy\n" +
"ebgklrmtxdqaynizupwsfv\n" +
"jswycqitzupnbavgofkdmlre\n" +
"kqprveytwzlmidfabunsg\n" +
"\n" +
"espgyfqvwctjxl\n" +
"nwselxvyjfcgqpta\n" +
"ljytpvqxgsewfc\n" +
"sfgwpctyjeqxvl\n" +
"xpwfztvryqujgcesl\n" +
"\n" +
"fak\n" +
"fa\n" +
"fa\n" +
"\n" +
"ci\n" +
"ic\n" +
"ic\n" +
"ic\n" +
"ic\n" +
"\n" +
"sdrecilmpta\n" +
"nyfuvjgt\n" +
"\n" +
"rjqtkb\n" +
"nrxdcigm\n" +
"\n" +
"lqxan\n" +
"axqnl\n" +
"lqxan\n" +
"xcnlaq\n" +
"\n" +
"miawyqxujdnobkts\n" +
"jumbid\n" +
"gimpdjbu\n" +
"\n" +
"ctbdnkajfrqwm\n" +
"qjadfnrck\n" +
"rndejhqckl\n" +
"\n" +
"qtnkxgwszufcdoje\n" +
"xwqufndojckegtzs\n" +
"okgwzcqxtsfuenjd\n" +
"tfksdqncoeuxwgzj\n" +
"gqkdzjtsnofcuexw\n" +
"\n" +
"y\n" +
"nmyh\n" +
"yh\n" +
"jty\n" +
"\n" +
"nosbgtm\n" +
"fitwzkryumnv\n" +
"\n" +
"xujltc\n" +
"uljbxt\n" +
"\n" +
"phwgolsikcumx\n" +
"luihpkgomwsr\n" +
"ijsglkwuhpom\n" +
"ohwkzupslmig\n" +
"phwimvsbulokcg\n" +
"\n" +
"qtko\n" +
"qotk\n" +
"qgokte\n" +
"oqkt\n" +
"\n" +
"nqhyfivrjes\n" +
"lewsrvpnijgcdyqtuaok\n" +
"\n" +
"ilsvdkqntza\n" +
"qlzvkfnidt\n" +
"lmtivdkqzun\n" +
"\n" +
"jitegscxbvkap\n" +
"bazxeirqcwkvsjg\n" +
"\n" +
"hztimlueapq\n" +
"htquipaezml\n" +
"emqhitlzapu\n" +
"mztlhqpuaei\n" +
"meizlupqhta\n" +
"\n" +
"qmhdij\n" +
"qdw\n" +
"wxqs\n" +
"yuagpvct\n" +
"\n" +
"njkbs\n" +
"iknbjs\n" +
"jndsbkr\n" +
"smgnkjbovwext\n" +
"bsnjk\n" +
"\n" +
"xzuajegmtvbfqcs\n" +
"gftvzmjscbaxqoeu\n" +
"veafutszgmibxqjc\n" +
"bstujmzvexqcagf\n" +
"\n" +
"zqwxeofgy\n" +
"vnysixbfwzdg\n" +
"myegxfzwtch\n" +
"wzrahfyuplkxgj\n" +
"\n" +
"b\n" +
"b\n" +
"b\n" +
"b\n" +
"\n" +
"oleycqk\n" +
"zexbflycq\n" +
"\n" +
"qkvaephtyjz\n" +
"qjazpteykv\n" +
"mybspqdavjkwz\n" +
"yjqzvpkat\n" +
"\n" +
"iex\n" +
"ieo\n" +
"i\n" +
"ji\n" +
"\n" +
"lzhjktifnavmsdpeqxwryg\n" +
"gprmilyhwnvjfxdztkasq\n" +
"jqzyaglmdtirfhxvskponw\n" +
"\n" +
"qthdgyc\n" +
"dqciylgth\n" +
"tqhyscgd\n" +
"dcyqghti\n" +
"qgczhydt\n" +
"\n" +
"tsngcywhrek\n" +
"wfvzlhpmsry\n" +
"\n" +
"sdawpinot\n" +
"npiwtzoda\n" +
"ndtwsaoixp\n" +
"nopaiwzst\n" +
"itflopwmnca\n" +
"\n" +
"dvpyhcuqwfxergbosl\n" +
"pxdhfqlewuvroygc\n" +
"xohlgwvceurdqfpy\n" +
"epcywvorhxuglfdq\n" +
"\n" +
"upcxrendiozjw\n" +
"edzrjoxcinpwu\n" +
"doucrjmeiwnpxz\n" +
"wxdpuzrjoneic\n" +
"\n" +
"gvfwrpudylze\n" +
"trmxawjqifz\n" +
"kudrzsvopgwhfn\n" +
"\n" +
"tc\n" +
"ct\n" +
"mct\n" +
"tc\n" +
"tc\n" +
"\n" +
"azfkv\n" +
"afvz\n" +
"fvztas\n" +
"afvz\n" +
"\n" +
"xwotv\n" +
"tvk\n" +
"pvt\n" +
"thv\n" +
"\n" +
"x\n" +
"ix\n" +
"\n" +
"n\n" +
"f\n" +
"n\n" +
"n\n" +
"n\n" +
"\n" +
"up\n" +
"up\n" +
"wpu\n" +
"pum\n" +
"udpr\n" +
"\n" +
"yftn\n" +
"k\n" +
"\n" +
"tluherb\n" +
"tjsgwcfympo\n" +
"\n" +
"nzlhtjicvwmqr\n" +
"ljngqvtmcz\n" +
"\n" +
"yet\n" +
"yte\n" +
"tye\n" +
"\n" +
"bwmfduzpi\n" +
"qzoa\n" +
"xceznyjo\n" +
"znetgq\n" +
"aoezny\n" +
"\n" +
"pzh\n" +
"hzp\n" +
"phuz\n" +
"\n" +
"zcgflrjb\n" +
"wequkjro\n" +
"\n" +
"egiqjdmruhb\n" +
"btyjzhukgoepvqr\n" +
"abehxcqrwsudjg\n" +
"\n" +
"m\n" +
"m\n" +
"m\n" +
"m\n" +
"m\n" +
"\n" +
"mkbqhjf\n" +
"ysxoweitglpudz\n" +
"rafmvnc\n" +
"\n" +
"hfaniqydo\n" +
"fyioq\n" +
"ilypofq\n" +
"fiolyq\n" +
"qifyot\n" +
"\n" +
"isklme\n" +
"isxelmk\n" +
"keimls\n" +
"smlike\n" +
"\n" +
"lusw\n" +
"swulc\n" +
"ulkzswti\n" +
"\n" +
"jlwkngbhoytrfzva\n" +
"thqfkgonjszlbvr\n" +
"rtqlfvoxghznkb\n" +
"iorbnmvetzplkfhg\n" +
"gfzlantkobrhcv\n" +
"\n" +
"a\n" +
"a\n" +
"a\n" +
"a\n" +
"a\n" +
"\n" +
"e\n" +
"o\n" +
"nx\n" +
"g\n" +
"\n" +
"wfahbinsdylmuqjg\n" +
"mdynhwasqjcgbuilf\n" +
"qagsbwdjifhymun\n" +
"bgsfnxcdlwquiyhmaj\n" +
"qzfagjrnmksdiuyhbwv\n" +
"\n" +
"bpjutscwgzqfaihn\n" +
"qapucwjtnszikgbf\n" +
"fcntgzhsiapjubwq\n" +
"gcqhijwsfuzptnba\n" +
"nicarpmztbqyxgfjwus\n" +
"\n" +
"lo\n" +
"oucynr\n" +
"zeo\n" +
"toxjd\n" +
"oq\n" +
"\n" +
"wsgkpblczumxatyefniqjdrovh\n" +
"dxngufpsbltmickjrohewaqzv\n" +
"zbvplfugitknxchaoqdwjmser\n" +
"\n" +
"rxl\n" +
"rx\n" +
"xr\n" +
"\n" +
"jre\n" +
"je\n" +
"\n" +
"enbyurosfwa\n" +
"abyrwsnfeo\n" +
"saywbonfer\n" +
"wrkseoafnzy\n" +
"\n" +
"bwzkdgjryteq\n" +
"smlhuefcnapoixv\n" +
"\n" +
"gvyspfxwk\n" +
"pxyksgvwf\n" +
"vfdpxsgwky\n" +
"pksygvxfw\n" +
"gyixskpvwf\n" +
"\n" +
"tbdok\n" +
"botkd\n" +
"\n" +
"hmi\n" +
"mih\n" +
"mhi\n" +
"simh\n" +
"\n" +
"nkahxedcorsvtz\n" +
"knrhzesodctaxv\n" +
"txdnezcvkahors\n" +
"ortdavxsznehkc\n" +
"\n" +
"zmgpf\n" +
"zfpm\n" +
"pfzmig\n" +
"zlkexfpa\n" +
"pztf\n" +
"\n" +
"xkru\n" +
"hurkx\n" +
"rypkxu\n" +
"ukrxh\n" +
"\n" +
"bk\n" +
"kbn\n" +
"bke\n" +
"kgba\n" +
"bk\n" +
"\n" +
"lmtnxdhvgowyzajqsric\n" +
"zwmhnvqaxjtordisyglc\n" +
"hotanmwvdsgljzcqiryx\n" +
"jymwvtzsrqgildcahxno\n" +
"hjrdlamgztwsviqncyox\n" +
"\n" +
"bewovp\n" +
"woveip\n" +
"oevp\n" +
"bziepov\n" +
"vjcpoex\n" +
"\n" +
"hwcjaflktixuys\n" +
"yfithlajvxdw\n" +
"fejthailwyx\n" +
"\n" +
"ekrshnlmyp\n" +
"nplurhzb\n" +
"dhsnrlg\n" +
"ilhtqrn\n" +
"\n" +
"bpkxsqmwljyacvdhi\n" +
"lsvmypxiwjdaq\n" +
"xqpgvkyaijlsdbu\n" +
"qdrayzlvjxitps\n" +
"\n" +
"akrelujqczvgmypxoftd\n" +
"dqfroxvktejgumclpzay\n" +
"rtmcvgaulpdexkfjqyzo\n" +
"axvjludqcktyfgpomrze\n" +
"prcvdlftgmjyaozeqxuk\n" +
"\n" +
"qytchokzabsvxjd\n" +
"ifgruvwndp\n" +
"\n" +
"lgedvcobj\n" +
"zivnmxkbp\n" +
"vtinhbry\n" +
"mqwsbv\n" +
"bpv\n" +
"\n" +
"etcasrvjlounbzfy\n" +
"exzapqlkgsdnvwtcfjo\n" +
"\n" +
"gimwrkealszjuovbqdxnfp\n" +
"hxbftzedakvspqguolwn\n" +
"axsvzfqewpbkhnguloyd\n" +
"\n" +
"aldgbhwosquzp\n" +
"nmtvykhfrelwi\n" +
"\n" +
"nqvmwaultx\n" +
"qvuaxmtnwl\n" +
"xuwlqnamvt\n" +
"alxwuqmtvn\n" +
"rvuamqlwtxn\n" +
"\n" +
"rgcvzjbpyqfsudomeilwat\n" +
"eyuxfmdcjgkhzraotqwpsibl\n" +
"\n" +
"jxszndrehyflgctubwoqvapk\n" +
"zpndwkgqcmbaelxvjthusroyf\n" +
"xojrdvbkayuqfcnhzipglewts\n" +
"\n" +
"ybedivlpkhxnz\n" +
"dzxihvkebynl\n" +
"vheyxkzdnibl\n" +
"\n" +
"tdlga\n" +
"tdagl\n" +
"ghatdl\n" +
"gldat\n" +
"avtldgm\n" +
"\n" +
"myqibrfdxcgjtnp\n" +
"ufswrvkqbyj\n" +
"rjqlafby\n" +
"yalcejhfdzqnrb\n" +
"\n" +
"x\n" +
"xve\n" +
"iwsbx\n" +
"\n" +
"psftnmuxrvqzaldk\n" +
"tfqrdpmzlavxknsu\n" +
"azluxtfnsvqkpmdr\n" +
"afvpqnzdtskxrulm\n" +
"qxknwpejtbamlurszdfv\n" +
"\n" +
"wc\n" +
"cdw\n" +
"wc\n" +
"cw\n" +
"\n" +
"jkhifrmaxlq\n" +
"lqfrajxhpvndbgm\n" +
"xqleamjhfr\n" +
"merqjhlxfa\n" +
"\n" +
"csrutxfibdola\n" +
"lxgfanpvsrhjeuiobc\n" +
"oiuxazlsfbrcd\n" +
"\n" +
"ntsi\n" +
"snti\n" +
"tisn\n" +
"tnis\n" +
"\n" +
"hipdn\n" +
"peixtuf\n" +
"\n" +
"fqrbuid\n" +
"qfruibvd\n" +
"\n" +
"dizhl\n" +
"divhlzwr\n" +
"ipdzhl\n" +
"\n" +
"jf\n" +
"fj\n" +
"fj\n" +
"fj\n" +
"\n" +
"eck\n" +
"ekc\n" +
"\n" +
"bpfi\n" +
"umzqfhn\n" +
"esybfp\n" +
"\n" +
"dpne\n" +
"pnqd\n" +
"\n" +
"wncfklxtuvbqphie\n" +
"imnzgkchyouedlbtpf\n" +
"kvufcitebhalqpsn\n" +
"ulehjtrnaibpkfc\n" +
"\n" +
"wd\n" +
"wd\n" +
"wnd\n" +
"\n" +
"iv\n" +
"iv\n" +
"iv\n" +
"\n" +
"xvord\n" +
"vx\n" +
"jnsxgwqe\n" +
"\n" +
"zgcqy\n" +
"a\n" +
"zuyf\n" +
"einwjlhsrkdp\n" +
"\n" +
"mudyqaignxe\n" +
"embyihxd\n" +
"kwrgiycpedx\n" +
"umtzkecixoyd\n" +
"jsfeyxdvil\n" +
"\n" +
"syeocvmxhkibzj\n" +
"obzyvrismxgafcd\n" +
"\n" +
"bkowp\n" +
"wpkb\n" +
"wkpb\n" +
"\n" +
"rgvoyctmuejfhsdz\n" +
"hnqlmcr\n" +
"kmhrcn\n" +
"\n" +
"ohvynfuicazjrxk\n" +
"jahnyzfviorkucgx\n" +
"pnckayhjxzrvuboif\n" +
"fuyrvnazojchkxi\n" +
"jyrauzvfcxkohni\n" +
"\n" +
"i\n" +
"i\n" +
"i\n" +
"\n" +
"ltiqpcerx\n" +
"fmxpcnyliq\n" +
"plihncogeq\n" +
"vsizqpcabkuld\n" +
"\n" +
"f\n" +
"f\n" +
"f\n" +
"f\n" +
"\n" +
"batgolqr\n" +
"sogutndzjlm\n" +
"ogtl\n" +
"\n" +
"mcnxgbfqe\n" +
"yujhieafqz\n" +
"ejqfhavw\n" +
"\n" +
"omjs\n" +
"orjsa\n" +
"\n" +
"ybh\n" +
"dwv\n" +
"sezxql\n" +
"ywo\n" +
"\n" +
"bfhgurcpyz\n" +
"cqjtpyzgblufxhswi\n" +
"hcfpmrzybgu\n" +
"\n" +
"dqxzencmaukypfrvjgoh\n" +
"ypnwjgredouqzhvmkx\n" +
"xqotjyupegmvkdznrh\n" +
"tgymxrqujnpwkezdvoh\n" +
"yugrzoxjqndkmhpev\n" +
"\n" +
"ijosae\n" +
"joisea\n" +
"isaejo\n" +
"\n" +
"mys\n" +
"wqcbzfl\n" +
"\n" +
"wuekzaijhotsmdylgb\n" +
"zbewmgxkhoduysitjvalp\n" +
"\n" +
"ufxmizkey\n" +
"ixkmfyeuz\n" +
"xmfyiukez\n" +
"umyzxkeif\n" +
"exkimufzy\n" +
"\n" +
"ljuwpkgqvym\n" +
"jqxnosecrkdzfmb\n" +
"\n" +
"uko\n" +
"kuo\n" +
"kou\n" +
"oscufzkx\n" +
"umok\n" +
"\n" +
"gtlkzfaxicsdwhepumvnbjr\n" +
"pwgnsjvutfdmrlbciaekxzh\n" +
"\n" +
"xtdefmu\n" +
"gvpyalkhtnzicmbq\n" +
"omwrjst\n" +
"\n" +
"iljqwxo\n" +
"tcofqu\n" +
"rqoapv\n" +
"fgdbnzpovuyq\n" +
"\n" +
"yzbekavtxf\n" +
"dujftxka\n" +
"ktoayxf\n" +
"pthaxcmnwkrqf\n" +
"tailfuyxgkjs\n" +
"\n" +
"phubt\n" +
"ba\n" +
"\n" +
"b\n" +
"b\n" +
"\n" +
"tfjplsdkiregzhwc\n" +
"brlekzcjhwqgtsif\n" +
"kjnhztesxiogvuralwcf\n" +
"lstjzwkeyrfighc\n" +
"\n" +
"lovhdzjgqt\n" +
"oliqtdgvsjrhu\n" +
"qhgolytvdj\n" +
"ldojqhtvg\n" +
"\n" +
"ehbogrjidxwznsafltp\n" +
"njoralfmvgipebzsdtwh\n" +
"nflhiotsbauepjgrwzkd\n" +
"\n" +
"avjftxwyilcdeohqpm\n" +
"tpyzdwaqjvmxlihocebsf\n" +
"oyrtcvqdhjinwafkemuxp\n" +
"\n" +
"qorwskbifymaulehpnjg\n" +
"qcrmgsfkyihlbuepwao\n" +
"\n" +
"wqitkcgvj\n" +
"rwzcotvjkg\n" +
"\n" +
"rwvnaqdjpkosftm\n" +
"zialxgbcohuednfsyp\n" +
"\n" +
"eytzxrasvwumic\n" +
"uajwnypqi\n" +
"uanhgwydji\n" +
"\n" +
"yljhebq\n" +
"qyhnje\n" +
"jqyhe\n" +
"eyhqj\n" +
"yqjohe\n" +
"\n" +
"hlpkbfvqm\n" +
"bpqkhvlf\n" +
"blqvnkzhpjfw\n" +
"\n" +
"mwirjqzcsh\n" +
"ioenbhkdflsxgu\n" +
"\n" +
"mywbh\n" +
"hb\n" +
"vbh\n" +
"\n" +
"rpj\n" +
"im\n" +
"gea\n" +
"\n" +
"v\n" +
"v\n" +
"v\n" +
"v\n" +
"v\n" +
"\n" +
"qf\n" +
"fq\n" +
"fq\n" +
"vqfkt\n" +
"qf\n" +
"\n" +
"lsdtouk\n" +
"gsjobmxdrn\n" +
"spyzfeohwdi\n" +
"\n" +
"kmwutyqlgprjexzvoh\n" +
"ovmpetrxqklhwujgz\n" +
"otzrgwvupmljkqxeh\n" +
"hewvzlorjmtgqxpku\n" +
"\n" +
"isoayqgnfwmjxlbr\n" +
"isfqagolrwnybj\n" +
"saoywgfjxbqrlin\n" +
"qbwvnoaiefsrjldgy\n" +
"losbangqrwfyji\n" +
"\n" +
"dupjhlezswngxi\n" +
"majwghxiuzsdeblqpf\n" +
"dpxulvsgijhwez\n" +
"hwzpjsludegxi\n" +
"dwjyuxkhgpilsze\n" +
"\n" +
"rskf\n" +
"rpsdk\n" +
"ksfr\n" +
"ljgsribkv\n" +
"ksr\n" +
"\n" +
"mckegajbrpvsqiwzh\n" +
"svuozijagxeqkwhptrbmn\n" +
"rkeqzpgmshwacjbvi\n" +
"\n" +
"bqalntdri\n" +
"baqdiltrn\n" +
"naribltdq\n" +
"tdlbnirqa\n" +
"\n" +
"zjlvfxi\n" +
"lxjiv\n" +
"\n" +
"ksep\n" +
"s\n" +
"s\n" +
"s\n" +
"s\n" +
"\n" +
"ubinslqeyctmh\n" +
"beyumsjnqcti\n" +
"nfbpuvsctzqwkiem\n" +
"mrnxusqybeilcgto\n" +
"\n" +
"prnqwhky\n" +
"lbywhjpq\n" +
"pimcfuvgya\n" +
"wpybn\n" +
"\n" +
"x\n" +
"x\n" +
"x\n" +
"x\n" +
"kt\n" +
"\n" +
"auvpzefg\n" +
"uazpgv\n" +
"ouzgpva\n" +
"oupagzv\n" +
"\n" +
"wqrhmzskpbyf\n" +
"zwobqgsyfmhkr\n" +
"qkwyjmhzrbsf\n" +
"\n" +
"beiyrdpuacwt\n" +
"bsmvp\n" +
"vlqphnbz\n" +
"jpbghxok\n" +
"\n" +
"ailjrzkvyd\n" +
"ardjlvzeyiq\n" +
"adkcjzryivel\n" +
"jvradlxziky\n" +
"giosfvntjpdylzbwmra\n" +
"\n" +
"ylbwsizepuxdcvrjh\n" +
"zrsljdpubvehciw\n" +
"bkevhdrsmwplziujc\n" +
"wpclhvbfiujzserd\n" +
"hiczvlbeswrujpd\n" +
"\n" +
"vfptxjoua\n" +
"axfkutovpj\n" +
"xuopvtfja\n" +
"fvxtpjoau\n" +
"\n" +
"qbndli\n" +
"qbwdla\n" +
"\n" +
"tvhwmursi\n" +
"dwtmuishrv\n" +
"rivhwstmu\n" +
"uhsvwmtir\n" +
"\n" +
"zobec\n" +
"oxznab\n" +
"oqtlbzy\n" +
"obcwsz\n" +
"wuxzob\n" +
"\n" +
"ia\n" +
"lcf\n" +
"aq\n" +
"yxepztur\n" +
"qjsf\n" +
"\n" +
"vsqg\n" +
"gs\n" +
"gs\n" +
"sg\n" +
"\n" +
"t\n" +
"t\n" +
"d\n" +
"t\n" +
"t\n" +
"\n" +
"f\n" +
"f\n" +
"ntfc\n" +
"\n" +
"abxpgzonuldwhfjyk\n" +
"zainyphtkrlxjdfbgw\n" +
"abndpoflxkywjgzhc\n" +
"bphazdxjglkywnf\n" +
"ynghblxjqpkufadzw\n" +
"\n" +
"lmcxjpyiqag\n" +
"ngpdzujlociqm\n" +
"pmcqyj\n" +
"pkejcfqmrvw\n" +
"\n" +
"nr\n" +
"yiran\n" +
"vnr\n" +
"njr\n" +
"\n" +
"hdrl\n" +
"dlcmq\n" +
"\n" +
"esqxdrjpu\n" +
"djgsrmq\n" +
"\n" +
"rspftxyhlkevi\n" +
"ylvsktxrifhpe\n" +
"esrlptfvywxihk\n" +
"\n" +
"ngm\n" +
"fuvyjbngmhk\n" +
"nrmg\n" +
"\n" +
"m\n" +
"ck\n" +
"a\n" +
"m\n" +
"\n" +
"hc\n" +
"bytowf\n" +
"p\n" +
"n\n" +
"\n" +
"mdexcsnhzkv\n" +
"jbzucr\n" +
"uiytcz\n" +
"paoczg\n" +
"\n" +
"otlxcp\n" +
"z\n" +
"efdv\n" +
"qz\n" +
"yjv\n" +
"\n" +
"sdbknm\n" +
"nsdmbk\n" +
"rmbsnkd\n" +
"mbdkns\n" +
"dskmnb\n" +
"\n" +
"umlokveradhcntgqzbjpwy\n" +
"enchjraufzvwpytoqg\n" +
"oevjinyzpgrumtwqachx\n" +
"\n" +
"hfg\n" +
"ef\n" +
"elf\n" +
"\n" +
"kqxtfgs\n" +
"tekngxfqb\n" +
"xgqmfvkt\n" +
"tkqfxyg\n" +
"xktqfgm\n" +
"\n" +
"qdyz\n" +
"dzsyuq\n" +
"zdqy\n" +
"pdozqyi\n" +
"qbyndz\n" +
"\n" +
"idnpythreuxf\n" +
"fprethyidu\n" +
"fqdprtuiehy\n" +
"herfydutpi\n" +
"\n" +
"cdpbmon\n" +
"rawhqg\n" +
"\n" +
"mbdsvyctkfqwoin\n" +
"cwekqsmonhafvidybt\n" +
"\n" +
"tfeukhxbylpvwigamc\n" +
"ygkfqirpmbdzuwxhelocav\n" +
"ikmpvcewngxualbyfh\n" +
"vcjfwnailyskbeupghxm\n" +
"\n" +
"xickua\n" +
"aickux\n" +
"kxcaius\n" +
"iuxack\n" +
"kuhcfaimx\n" +
"\n" +
"hxbule\n" +
"bhluex\n" +
"uhelx\n" +
"lzxhue\n" +
"\n" +
"dkzxhwjqnlgsumciypb\n" +
"hwognlupqvfzcmbkyars\n" +
"\n" +
"efdoxlmcpaytrbuh\n" +
"bjwhcteomykxdl\n" +
"qhcbmxdleyto\n" +
"\n" +
"d\n" +
"q\n" +
"d\n" +
"\n" +
"bhfat\n" +
"uvlb\n" +
"\n" +
"twfhsjrgopzqydu\n" +
"goupftshjrwqbzeyd\n" +
"hgwrintjdsyofqpz\n" +
"mjortzlsfdvywhqap\n" +
"\n" +
"pvmhaeuqdnkzfy\n" +
"uezhysmqokpa\n" +
"\n" +
"dveyafokgmrjclp\n" +
"zvoygwbqirseapmf\n" +
"\n" +
"jkowpdlginzmc\n" +
"hlnzojpcmgdiw\n" +
"wczdilpjmsyngo\n" +
"\n" +
"uahlztofcpimqrdwkjgbn\n" +
"fuzhebpndmglkrwxjtiqa\n" +
"tlfqnwizbkpxuavhmjgrd\n" +
"\n" +
"lsjcy\n" +
"cjylas\n" +
"ylsc\n" +
"yscal\n" +
"smlyc\n" +
"\n" +
"mih\n" +
"hdiumkq\n" +
"himt\n" +
"\n" +
"otxsqver\n" +
"mofgyxr\n" +
"jubnhdorcw\n" +
"rsliopqke\n" +
"\n" +
"dqaxlovt\n" +
"twavx\n" +
"\n" +
"pbgy\n" +
"hpnar\n" +
"myp\n" +
"\n" +
"jtzsplhfbvqocwuemx\n" +
"jqmobpexzlutswfc\n" +
"cipxtzqfmwlosbjedu\n" +
"pzxqlbwtcfjkoumse\n" +
"\n" +
"sizhfjnrql\n" +
"rylzfinh\n" +
"fnrlhizgvd\n" +
"flhrinzp\n" +
"\n" +
"ytcraijhfpbkzlxu\n" +
"qfuxrjclgoytiabzkph\n" +
"jhtklbpzxuinarcyfg\n" +
"hmjuliayvsfzktpxcbwr\n" +
"\n" +
"gvciksejwpx\n" +
"hpfgtmkexcrqjv\n" +
"gxskpjcev\n" +
"cpxjgaekv\n" +
"jcxvkpge\n" +
"\n" +
"axdftocrsbhup\n" +
"fpxhobqactr\n" +
"\n" +
"tybocwmnvxq\n" +
"cqvsnwxmty\n" +
"yxwtvcmnq\n" +
"twyxnoqmvc\n" +
"\n" +
"yujodbhfxcqrv\n" +
"jqobfyhdvxcnru\n" +
"ofhbeujvcrqyxd\n" +
"\n" +
"eakgq\n" +
"gakqe\n" +
"akgqe\n" +
"ekgaq\n" +
"qekag\n" +
"\n" +
"melvoydtazcfqki\n" +
"kamyzodfvclietq\n" +
"amqkfygntdliovezch\n" +
"idkqmyactzfevol\n" +
"akiqdtymvczfeol\n" +
"\n" +
"ni\n" +
"inac\n" +
"iny\n" +
"ink\n" +
"\n" +
"j\n" +
"jl\n" +
"oj\n" +
"\n" +
"x\n" +
"k\n" +
"k\n" +
"k\n" +
"k\n" +
"\n" +
"saiozgntjulkh\n" +
"augth\n" +
"tgarufheq\n" +
"ahtxgu\n" +
"epbhaugt\n" +
"\n" +
"joquah\n" +
"ausoqh\n" +
"khajoqu\n" +
"\n" +
"fmrwjtpqyebaixc\n" +
"cqebxjwpfaryitm\n" +
"fqmrtjxebicypaw\n" +
"\n" +
"w\n" +
"w\n" +
"j\n" +
"qo\n" +
"n\n" +
"\n" +
"thlpbumvgq\n" +
"pcgrinesl\n" +
"\n" +
"p\n" +
"p\n" +
"d\n" +
"s\n" +
"p\n" +
"\n" +
"vslzthkf\n" +
"tkhczfnsv\n" +
"tkfhvzs\n" +
"\n" +
"qremnidlvkhugzftyjsopab\n" +
"dvmgxfeqwurhcnp\n" +
"\n" +
"tjc\n" +
"ijc\n" +
"\n" +
"xejycvfhbq\n" +
"ebjfnyvxcq\n" +
"pfedtbyvjqcx\n" +
"yvqecfbxjn\n" +
"\n" +
"gprnslzexdthauqfim\n" +
"anlgukphzrtxe\n" +
"\n" +
"bpxgoqlvushjwnt\n" +
"wpklduyngfoezvrhts\n" +
"wjnhioqsxpctvgul\n" +
"\n" +
"sdp\n" +
"ups\n" +
"ptucs\n" +
"\n" +
"owscyrlhzn\n" +
"qszonlymh\n" +
"gonsdpzhyl\n" +
"\n" +
"xeo\n" +
"eox\n" +
"\n" +
"pdblxaetg\n" +
"aptdxlg\n" +
"\n" +
"uecnzlk\n" +
"vznctul\n" +
"eunsxrv\n" +
"wyibmqnudjha\n" +
"\n" +
"rwfokecv\n" +
"ekwfor\n" +
"rskoen\n" +
"qrkuloaepyz\n" +
"evdkbrso\n" +
"\n" +
"zogvdr\n" +
"hzgvrdp\n" +
"agwjytdebi\n" +
"\n" +
"ugkxzwyt\n" +
"xncpgwbkt\n" +
"\n" +
"l\n" +
"il\n" +
"blm\n" +
"ilv\n" +
"\n" +
"nubve\n" +
"eunbv\n" +
"vnbe\n" +
"bmevdn\n" +
"envb\n" +
"\n" +
"vebyf\n" +
"fsbjvy\n" +
"lsvm\n" +
"tuihvwoqn\n" +
"xfv\n" +
"\n" +
"evodlaryn\n" +
"xynlave\n" +
"nvlearyf\n" +
"snyadlev\n" +
"\n" +
"xfdvm\n" +
"vxmfd\n" +
"\n" +
"bug\n" +
"bgruv\n" +
"ugb\n" +
"gub\n" +
"\n" +
"cet\n" +
"aflq\n" +
"ej\n" +
"bryc\n" +
"\n" +
"nohgldscazxrpyim\n" +
"srznmdplaycioghx\n" +
"gmxodyprnhcsialz\n" +
"\n" +
"tonbhvsxqedykjapg\n" +
"rewcvimxlnzujfd\n" +
"\n" +
"zuvelkx\n" +
"elkzbuvx\n" +
"bvlzukxe\n" +
"qvkexulz\n" +
"\n" +
"mn\n" +
"hom\n" +
"dm\n" +
"\n" +
"japidxzgs\n" +
"pgsijdfx\n" +
"mekyliuorbvcn\n" +
"\n" +
"dunbzyopim\n" +
"iugxobzsny\n" +
"nyqtebkroiu\n" +
"\n" +
"ih\n" +
"tih\n" +
"ih\n" +
"\n" +
"raxp\n" +
"r\n" +
"\n" +
"syapwhiklvdcnfzgur\n" +
"zdkchaswfbnuyirpvgl\n" +
"\n" +
"lcudqgsexvrtfhinzpkyjwo\n" +
"uqerwhnsjkyfdtilvgxcozp\n" +
"jfeclvodtwkyushrpiqzgn\n" +
"mirkjzabqhgvnlsewdpocufty\n" +
"\n" +
"dxwjlvfrmks\n" +
"dwrvjmxksl\n" +
"\n" +
"sfqcdlwtjiv\n" +
"jsdicfwtqvl\n" +
"dqfjvcilwts\n" +
"jdqvwcslfit\n" +
"\n" +
"jibxdpkanysqlvceh\n" +
"cvnxwydjpaqbksleh\n" +
"fpdnqvaxuckhbylse\n" +
"\n" +
"usajkywgoem\n" +
"ogesuajyvk\n" +
"\n" +
"y\n" +
"y\n" +
"\n" +
"xaqrhcojtdnzysufb\n" +
"bhxfuozcansdtjyqr\n" +
"nydfstobzrcjqmaxuh\n" +
"\n" +
"hozjminaverc\n" +
"mpsarehivzn\n" +
"mnvdxprziehfalw\n" +
"hievykrwmznaqg\n" +
"\n" +
"ubaimoqltevpkcn\n" +
"rfzwejsgtvyxbdq\n" +
"\n" +
"qrz\n" +
"z\n" +
"yz\n" +
"\n" +
"gdx\n" +
"dxgi\n" +
"\n" +
"vncstgo\n" +
"javc\n" +
"pbkevc\n" +
"pvc\n" +
"\n" +
"rxlpku\n" +
"lmkxsu\n" +
"\n" +
"kzp\n" +
"zkp\n" +
"zpk\n" +
"\n" +
"kjeqiahytozcg\n" +
"yjzqthgfkae\n" +
"hzaytejpgkq\n" +
"azyjgheqtk\n" +
"agtzhkfjyqe\n" +
"\n" +
"erzmkohpb\n" +
"zkeobrhmp\n" +
"morhbzpek\n" +
"zkerbphmo\n" +
"pkbzermovh\n" +
"\n" +
"jblidhtnermq\n" +
"emblhtndqir\n" +
"ildnhteqmbr\n" +
"tbqewhilnrdm\n" +
"nitmqrdlehb\n" +
"\n" +
"gzsjwoedqyn\n" +
"weogqjsdyz\n" +
"wezqydjgso\n" +
"eojsyqgwdz\n" +
"eydwojzsqg\n" +
"\n" +
"nwbjemxcfvagdluhk\n" +
"euamwhfdgnvkjcblx\n" +
"gbvelhfakmujtxndcw\n" +
"lhnfxcmgavjkdbewu\n" +
"endfbkpxuljhcwavmg\n" +
"\n" +
"hdcvzsygoemla\n" +
"ktbfdiqjwnxur\n" +
"\n" +
"uvw\n" +
"uvrw\n" +
"uvw\n" +
"\n" +
"yexhwqvbzor\n" +
"xqberuiwphy\n" +
"xqyrjegwbhs\n" +
"\n" +
"xqrasilmvczjn\n" +
"saqxmivjzflc\n" +
"vmixfkjaclzqs\n" +
"\n" +
"jsximkbwlvanq\n" +
"nadixwkvslb\n" +
"icanwkphebsvlx\n" +
"lnkyxaguitrbvws\n" +
"\n" +
"owqbulsmaxtezyvgj\n" +
"qobastglyxzwumj\n" +
"fzsxtulmqgyojwba\n" +
"wysxltjqbogkfauzm\n" +
"\n" +
"zjtmghkprixqbduwav\n" +
"dprkxhwzibgvtmuqja\n" +
"\n" +
"bn\n" +
"nb\n" +
"bn\n" +
"bn\n" +
"rnb\n" +
"\n" +
"xuchertd\n" +
"rxcze\n" +
"\n" +
"umx\n" +
"wxm\n" +
"kxdm\n" +
"mx\n" +
"\n" +
"msvr\n" +
"ykiqse\n" +
"lsqfi\n" +
"sfz\n" +
"slefkq\n" +
"\n" +
"duiqworatzmfehgy\n" +
"sotydehqufiwazgrb\n" +
"\n" +
"lwosrqtknhjayxcv\n" +
"iyxgqntrhskd\n" +
"hayokstqncxrj\n" +
"\n" +
"o\n" +
"or\n" +
"\n" +
"sb\n" +
"sb\n" +
"sb\n" +
"\n" +
"ftyecprw\n" +
"cprwy\n" +
"ylpbcwzr\n" +
"cwpyr\n" +
"bdyorcwzp\n" +
"\n" +
"zuilqrtvo\n" +
"ujvotniw\n" +
"iwvontu\n" +
"avisokut\n" +
"\n" +
"mhbzakospnf\n" +
"famsugheytkopvn\n" +
"bmpaslnifhzok\n" +
"ocfqswnhkapm\n" +
"jaorpsknmdfh\n" +
"\n" +
"rjxepmakhtvgwyzulqodsnc\n" +
"udolsqhtxmprnzbeacgkj\n" +
"ajdtmuyxoszernlhcgkpq\n" +
"oesjfmqxugirdkhclatnp\n" +
"xmjtpawnrehqogkcduls\n" +
"\n" +
"vwtzqilospxmnbhdr\n" +
"qrkcmgdapvohetsfzwyl\n" +
"\n" +
"mduoq\n" +
"uqomdf\n" +
"\n" +
"fzuwmjltyxvdagecikpbhor\n" +
"qwzdnmsxhrlefctoaiupk\n" +
"\n" +
"xluzmjowiafbkyps\n" +
"mfsnjuapbwoyxikzvl\n" +
"auifrkzxsgbwolymp\n" +
"abxzukpswymolif\n" +
"\n" +
"uengwta\n" +
"kngts\n" +
"\n" +
"d\n" +
"jd\n" +
"d\n" +
"dab\n" +
"d\n" +
"\n" +
"enjcqx\n" +
"ncqjxeu\n" +
"jeqncx\n" +
"cjeqxn\n" +
"\n" +
"lm\n" +
"lpm\n" +
"lhum\n" +
"lqmv\n" +
"\n" +
"beyfkhxvp\n" +
"pefvbkyhx\n" +
"pykefhxbv\n" +
"xbkupyvhe\n" +
"\n" +
"mqxgvohazrfybjcp\n" +
"piyxdejohmqvbfz\n" +
"\n" +
"vbzjgqhft\n" +
"zvujtbqhfg\n" +
"hvfjeqbzgt\n" +
"bhqgvftjz\n" +
"htzqgbjfv\n" +
"\n" +
"sfltzmbjgecriwxkh\n" +
"wjesmhrkiqltbxzcgf\n" +
"\n" +
"dqjmgwroystpnab\n" +
"oqmycsgidaptbjnl\n" +
"zuvydaxbstgopqmn\n" +
"ngytpsimbadoq\n" +
"\n" +
"weotrpjaxlyqkd\n" +
"pkxwrsljzqeytdo\n" +
"roxakpmjqewtld\n" +
"worjtpdxlekq\n" +
"rukepndlxvqjtwbo\n" +
"\n" +
"gskrftnxaow\n" +
"hnziodkfvt\n" +
"\n" +
"zctyihajwk\n" +
"kvwhjiszcatye\n" +
"ychijkuzatw\n" +
"ijyhckwtza\n" +
"\n" +
"rtyldsvjnckpz\n" +
"rndlcysvzktpj\n" +
"zsrvcytdklpjn\n" +
"\n" +
"vzmoxkuseptgr\n" +
"wkxreogtvupz\n" +
"\n" +
"oebdwusyzfpn\n" +
"eidnzygub\n" +
"bzdyunes\n" +
"jhdzxuyqnerb\n" +
"uenbydz\n" +
"\n" +
"hqifzwampdgjxvbncso\n" +
"svoblpfdxcnzwirahmjkq\n" +
"aqodwenhvxmsbfzikypcj\n" +
"\n" +
"fnvg\n" +
"gnt\n" +
"seng\n" +
"fng\n" +
"\n" +
"wcfgudlrsp\n" +
"wrpldhsfugc\n" +
"\n" +
"awrmnoptquslfxdg\n" +
"zdyptmwlrabgfseouq\n" +
"\n" +
"czhne\n" +
"eczk\n" +
"gwelcuf\n" +
"\n" +
"kz\n" +
"z\n" +
"z\n" +
"z\n" +
"z\n" +
"\n" +
"xbkgjfdpamylhqws\n" +
"mpwkgilhxaybdtjqesf\n" +
"xfbvjyduzqrpngsmklhoa\n" +
"bqamskichdfltgyxpj\n" +
"\n" +
"t\n" +
"t\n" +
"\n" +
"bgtf\n" +
"bftg\n" +
"bifmtg\n" +
"bgtf\n" +
"\n" +
"enom\n" +
"eon\n" +
"\n" +
"hsgwm\n" +
"msgvncaoe\n" +
"kstrdlufp\n" +
"\n" +
"pwdsbif\n" +
"aiemt\n" +
"\n" +
"adcvfrseuypibqzlgo\n" +
"zebpcvogarquflyisdh\n" +
"cadfqiuzbgylrwnepsvo\n" +
"ouseigmzyqplbdafvcr\n" +
"pyqzvrkdxoaesfcbuljgi\n" +
"\n" +
"p\n" +
"p\n" +
"po\n" +
"p\n" +
"\n" +
"rknoufbe\n" +
"ixatyzcqm\n" +
"jlesufp\n" +
"vuwnofg\n" +
"\n" +
"xudvlzqckjiwpergnfmoa\n" +
"umgfvarnioqpecjdzwlk\n" +
"\n" +
"mtqpxdrgyiujkh\n" +
"dpjymirtkuqhgx\n" +
"xkhtpmyirqujgd\n" +
"mtijghkopudqxyr\n" +
"\n" +
"swobxzmlfvacp\n" +
"atupbcwmz\n" +
"pacwbzm\n" +
"bpmczaw\n" +
"czbampw\n" +
"\n" +
"mecbjzxthldokvwr\n" +
"mbszuxwdrfclqkjnvta\n" +
"\n" +
"ar\n" +
"ra\n" +
"\n" +
"sqlcrbvagdh\n" +
"hrvqydcbegsx\n" +
"umvfhrckqpsbg\n" +
"hrdbcyqjsgv\n" +
"\n" +
"tarvqx\n" +
"qbri\n" +
"\n" +
"elzrapiufomjs\n" +
"ujcriszamlfoe\n" +
"euraiozmjlfs\n" +
"gmjoaiszlerfu\n" +
"\n" +
"zisv\n" +
"wvszi\n" +
"ivqfzs\n" +
"isvz\n" +
"zivs\n" +
"\n" +
"nhbzgqirmpe\n" +
"ojcta\n" +
"yzpfsv\n" +
"\n" +
"qgzi\n" +
"gqifz\n" +
"izgq\n" +
"\n" +
"tedxocajnwb\n" +
"zdyvxtfkhgrcqs\n" +
"\n" +
"i\n" +
"i\n" +
"i\n" +
"\n" +
"snuaw\n" +
"wsu\n" +
"wsuo\n" +
"osuw\n" +
"\n" +
"ywedhx\n" +
"jwypitehxq\n" +
"\n" +
"jd\n" +
"j\n" +
"j\n" +
"j\n" +
"j\n" +
"\n" +
"miwxhuftya\n" +
"emlgtyrop\n" +
"mvybzqdktns\n" +
"\n" +
"fdrnsgxctzwbyl\n" +
"rctpdzuyxnwgfsl\n" +
"zkwnsfglcdtxpry\n" +
"ethrgnoqjxzfdayclvsw\n" +
"sgdyrfpxwnltcz\n" +
"\n" +
"pmqf\n" +
"mpl\n" +
"\n" +
"glabuzr\n" +
"gbzula\n" +
"gzaubl\n" +
"bulzag\n" +
"ulgzba\n" +
"\n" +
"hgaifknzbdyoceqwjt\n" +
"bzmswrqonijlvtykea\n" +
"\n" +
"cpjlbahiekfrmuzsndtgqyowvx\n" +
"qgrtsdijmpfabxkweuzyvhlnco\n" +
"\n" +
"vbgq\n" +
"tdhs\n" +
"\n" +
"iqzvluae\n" +
"eaqvi\n" +
"\n" +
"tgcqhufklsniozjrdp\n" +
"rozpqhjugiclfdtnk\n" +
"tdhoijqlfpugnrczk\n" +
"\n" +
"pmcjodek\n" +
"odjmelcp\n" +
"ojdqmptnvgi\n" +
"\n" +
"mwzhqrancjixtvlouydb\n" +
"aocjupytmwnxdrvhbqz\n" +
"\n" +
"mtgfuljbynkheoawr\n" +
"qmljgbkenfhuarztwo\n" +
"bfjhuemklgtarnoq\n" +
"vkrcganiltfeoshjmbu\n" +
"\n" +
"f\n" +
"d\n" +
"r\n" +
"d\n" +
"\n" +
"blkiqxw\n" +
"lbixk\n" +
"kblxi\n" +
"\n" +
"tygbuvlsqzdcwjfmphor\n" +
"fjvqkyuhdmlrgbat\n" +
"\n" +
"eawoshikf\n" +
"lcynruzxvajmpbtkd\n" +
"\n" +
"lqnjxavz\n" +
"vqxjnlaz\n" +
"nlvjzaqx\n" +
"\n" +
"zcetsupmg\n" +
"csgztmup\n" +
"cptsgzumjn\n" +
"\n" +
"v\n" +
"v\n" +
"v\n" +
"v\n" +
"vh\n" +
"\n" +
"smw\n" +
"wkm\n" +
"mkw\n" +
"\n" +
"jznk\n" +
"gfhi\n" +
"gh\n" +
"qlym\n" +
"\n" +
"ryncitzgwj\n" +
"tpgfavxeqsbnjz\n" +
"jzngrtm\n" +
"yotjznklg\n" +
"\n" +
"ks\n" +
"csp\n" +
"sk\n" +
"\n" +
"wrq\n" +
"h\n" +
"swvf\n" +
"wpj\n" +
"notbazycm\n" +
"\n" +
"vgqxwbruetaynispjh\n" +
"mkxbqyljiphsuwvned\n" +
"vnpwuqixhybejs\n" +
"ejqsyhpxbniwvu\n" +
"\n" +
"tbvngcxkzluowmfd\n" +
"bzktxmvdlwocnguf\n" +
"kmdzvwuxnlofbctg\n" +
"dtfbxckvuoznwmlg\n" +
"vcxogmndfuzwblkt\n" +
"\n" +
"begtyqocndxfikjlpr\n" +
"ndrbehqgptfjyko\n" +
"beryqugtndofkjp\n" +
"eobqphdntgjrkfy\n" +
"botjdhfgrepkyqn\n" +
"\n" +
"hq\n" +
"dv\n" +
"\n" +
"cxvfaprgiksneduzbj\n" +
"kgaenulpdqiwcvjmfxy\n" +
"\n" +
"cnlrmw\n" +
"gmn\n" +
"pymqh\n" +
"\n" +
"xvpcbhflyan\n" +
"hlaypfncxbv\n" +
"\n" +
"aoluxvjcfdhmtyb\n" +
"tnahjxvlubdmyfco\n" +
"fyjmdhxatlubcvo\n" +
"hcuaolvpmxjbydfrt\n" +
"\n" +
"egtqbrkhvzj\n" +
"trbyzvhgckl\n" +
"rzgitvkhbdw\n" +
"\n" +
"nshdqipy\n" +
"\n" +
"u\n" +
"yu\n" +
"vu\n" +
"tiu\n" +
"uv\n" +
"\n" +
"qiauofxksbpdygrljntw\n" +
"rodkyqglbtixjnpfasuw\n" +
"gorwdunfljqxitybpks\n" +
"rtygakqpxsfowiujbdnl\n" +
"qdwrfntpkguyjblhxios\n" +
"\n" +
"elinckrvajxofdwu\n" +
"mlktzwjnrpaxofiq\n" +
"\n" +
"lynoba\n" +
"akdprjmbn\n" +
"bja\n" +
"gzeab\n" +
"\n" +
"oqpmxd\n" +
"ouds\n" +
"zodiu\n" +
"dozjwauqx\n" +
"kerdhob\n" +
"\n" +
"kbfzid\n" +
"khfi\n" +
"wykefui\n" +
"\n" +
"zetdacmfxg\n" +
"aijvmxcptboze\n" +
"mnzktlaxchqye\n" +
"zxwmucgesta\n" +
"\n" +
"zoxbtyj\n" +
"plhug\n" +
"sukp\n" +
"dqi\n" +
"lpc\n" +
"\n" +
"u\n" +
"u\n" +
"u\n" +
"w\n" +
"u\n" +
"\n" +
"yiqfdmwlp\n" +
"fgewipylqm\n" +
"pilwyqmf\n" +
"lzmwnyptifq\n" +
"lwpmtfiyq\n" +
"\n" +
"oaqwidsuztk\n" +
"fjbsglrmxnvapyh\n" +
"sudecatwo\n" +
"\n" +
"cbhzygwtfr\n" +
"hrfcwtbyzgx\n" +
"zywifrctgb\n" +
"\n" +
"qawljghbftu\n" +
"ouxmapdlfirgsjw\n" +
"\n" +
"doxz\n" +
"zrwhm\n" +
"z\n" +
"zd\n" +
"\n" +
"hsry\n" +
"rys\n" +
"ryst\n" +
"\n" +
"eyosib\n" +
"oebrsdy\n" +
"\n" +
"ezranh\n" +
"ayftjvn\n" +
"\n" +
"iwsnt\n" +
"sitcwn\n" +
"itowns\n" +
"\n" +
"aemipyl\n" +
"kdnqwucol\n" +
"svoluh\n" +
"\n" +
"tb\n" +
"b\n" +
"b\n" +
"\n" +
"nhyprdzjfkx\n" +
"yxrfojnhzdkp\n" +
"rmylunxfkjhdzpab\n" +
"yfnjpxkzrdh\n" +
"rpqkxyznjdfh\n" +
"\n" +
"qtpfgnkwmz\n" +
"erykph\n" +
"\n" +
"rcknbzgplv\n" +
"ljidmrpvgsynhfxcw\n" +
"ualqcovet\n" +
"\n" +
"pmjfqvw\n" +
"wqi\n" +
"\n" +
"cnrfbmpx\n" +
"qcrmbpx\n" +
"qxbkcrmp\n" +
"pdcembrxh\n" +
"kcxpvrbm\n" +
"\n" +
"vzjsqergibonfpcwxdu\n" +
"wsjzqeyfxrpidgbv\n" +
"hvdzojwqfxespbgir\n" +
"iafjvkbzdpgwxmsreq\n" +
"\n" +
"unhm\n" +
"hunm\n" +
"\n" +
"xszhfvrg\n" +
"rhfvsxzg\n" +
"fhzxrsgv\n" +
"fhsvrzgx\n" +
"\n" +
"fsczkoeltjnaxyqgv\n" +
"oqagsvntxjz\n" +
"xtnzvasgqojp\n" +
"\n" +
"dvwir\n" +
"iwdvr\n" +
"wrdiv\n" +
"rwvid\n" +
"\n" +
"zgimtew\n" +
"tdxkab\n" +
"\n" +
"ngyvcmklw\n" +
"nbwkclgym\n" +
"\n" +
"efznbqgxkr\n" +
"zkfrbgqxen\n" +
"grxqbfznek\n" +
"fegqzkxpbnr\n" +
"\n" +
"for\n" +
"for\n" +
"rfo\n" +
"fro\n" +
"orf\n" +
"\n" +
"hmjunqdopzebrtfgsaycxk\n" +
"hxqunoswjyfaezmcdrgkpbt\n" +
"\n" +
"rvsbolmafxzjugw\n" +
"fjhoxarsuyzpbegcvw\n" +
"jwforbvdugaxzst\n" +
"\n" +
"xv\n" +
"oxhd\n" +
"x\n" +
"\n" +
"wgz\n" +
"yzwgr\n" +
"\n" +
"uvyq\n" +
"uvqy\n" +
"vqyu\n" +
"yvuq\n" +
"vquy\n" +
"\n" +
"l\n" +
"v\n" +
"l\n" +
"kewx\n" +
"lu\n" +
"\n" +
"xliyjcvkpesbqmt\n" +
"clxobwftkj\n" +
"tbfkjxlczn\n" +
"\n" +
"vxfos\n" +
"obcxsh\n" +
"loisq\n" +
"mxovs\n" +
"yosbncfk\n" +
"\n" +
"lgmbfvn\n" +
"fmrnbivlg\n" +
"gnflbvm\n" +
"bnmlfgv\n" +
"\n" +
"gmyqnj\n" +
"snmjgq\n" +
"mgdqj\n" +
"gjmeqw\n" +
"gomvsjq\n" +
"\n" +
"jlfwpg\n" +
"fzntmes\n" +
"\n" +
"neuagywtl\n" +
"exnyjtulgwa\n" +
"nysltwaueg\n" +
"hatenlvuywdcg\n" +
"\n" +
"rdklg\n" +
"rlgk\n" +
"gkrl\n" +
"kwcxrgl\n" +
"\n" +
"ykqdrlcnsvtj\n" +
"yqvrdksjncmt\n" +
"\n" +
"dtrugibvznex\n" +
"nertvzuidsxg\n" +
"vnrdegxtziq\n" +
"ivgrlxndtze\n" +
"vgadxrtynzeif\n" +
"\n" +
"hlrqu\n" +
"ngd\n" +
"\n" +
"vknisul\n" +
"uiaxnvde\n" +
"vqlukoin\n" +
"\n" +
"pan\n" +
"vnamp\n" +
"\n" +
"ah\n" +
"fyck\n" +
"dsglmrwvobqeizxjun\n" +
"pty\n" +
"hkp\n" +
"\n" +
"ydermuatbqc\n" +
"heqtzu\n" +
"\n" +
"azsl\n" +
"jvazulsg\n" +
"vtjlzsa\n" +
"madphqbzflkws\n" +
"\n" +
"nocuqyxh\n" +
"oucyhxqn\n" +
"ouncqyhx\n" +
"xuncyhoq\n" +
"\n" +
"j\n" +
"e\n" +
"e\n" +
"e\n" +
"\n" +
"qyrmwabifdtgjszh\n" +
"rdjtywamsgibhzqf\n" +
"tszrqmwjagbydhf\n" +
"sqhlgajmnydvtzfucwbrk\n" +
"ahsfwqtmrbdzjyg\n" +
"\n" +
"iqhlxyofejm\n" +
"bloxehyifj\n" +
"xjfieyhlo\n" +
"\n" +
"skblf\n" +
"fkl\n" +
"\n" +
"ygstldmxfweuzq\n" +
"tmuvzfqysxeglwi\n" +
"czqxoemgyustfrb\n" +
"\n" +
"garndlcxfuw\n" +
"wrdulxgqfac\n" +
"gfloiuzhwdcxvar\n" +
"\n" +
"dwqxfekvtn\n" +
"wknsetqdfxv\n" +
"dfqknxevtw\n" +
"edtwfqxvnk\n" +
"wtfkmrdhevqnx";

        return Arrays.stream(inputStr.split("\n\n"));
    }
}