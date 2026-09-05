package bullhit;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class LoadSimulation extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://localhost:8080")
    .inferHtmlResources()
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/152.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7"),
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "none"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"152\", \"Not?A_Brand\";v=\"24\", \"Google Chrome\";v=\"152"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("sec-ch-ua", "Chromium\";v=\"152\", \"Not?A_Brand\";v=\"24\", \"Google Chrome\";v=\"152"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7"),
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("Origin", "http://localhost:8080"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"152\", \"Not?A_Brand\";v=\"24\", \"Google Chrome\";v=\"152"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("Accept-Encoding", "gzip, deflate, br, zstd"),
    Map.entry("Accept-Language", "he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Chromium\";v=\"152\", \"Not?A_Brand\";v=\"24\", \"Google Chrome\";v=\"152"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );


  private ScenarioBuilder scn = scenario("LoadSimulation")
    .exec(
      http("request_0")
        .get("/NogaHenAvivYam-BullHitGame/")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/favicon.ico")
            .headers(headers_1)
        ),
      pause(10),
      http("request_2")
        .post("/NogaHenAvivYam-BullHitGame/")
        .headers(headers_2)
        .formParam("guess", "ABCD"),
      pause(9),
      http("request_3")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("guess", "AABB"),
      pause(4),
      http("request_4")
        .get("/NogaHenAvivYam-BullHitGame/rules.jsp")
        .headers(headers_4),
      pause(3),
      http("request_5")
        .get("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_4),
      pause(2),
      http("request_6")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("action", "reset"),
      pause(14),
      http("request_7")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("guess", "ABCD"),
      pause(7),
      http("request_8")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("guess", "EFAB"),
      pause(5),
      http("request_9")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("guess", "GHEF"),
      pause(27),
      http("request_10")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("guess", "GABH"),
      pause(8),
      http("request_11")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("guess", "GCDH"),
      pause(20),
      http("request_12")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("guess", "HCAE"),
      pause(10),
      http("request_13")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("guess", "CAEH"),
      pause(5),
      http("request_14")
        .post("/NogaHenAvivYam-BullHitGame/index.jsp")
        .headers(headers_2)
        .formParam("action", "reset")
    );

  {
    setUp(
        scn.injectClosed(
            rampConcurrentUsers(0).to(8000).during(60),
            constantConcurrentUsers(8000).during(180),
            rampConcurrentUsers(8000).to(0).during(60)
        )
    ).protocols(httpProtocol);
  }
}
