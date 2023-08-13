# spring-kafka-streams
spring boot + kafka + kafka streams 를 이용한 공부 ㅠ

``` bash
docker-compose -f docker-compose-single.yml up -d

# test 라는 토픽 생성
docker exec kafka-streams_kafka_1 kafka-topics --create --topic test --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1

# test 라는 토픽 상세 정보 조회
docker exec kafka-streams_kafka_1 kafka-topics --describe --topic test—bootstrap-server kafka:9092 

------ # 그 외
# 현재 브로커의 연결된 컨슈머 그룹들 조
docker exec kafka-streams_kafka_1 kafka-consumer-groups --bootstrap-server kafka:9092 --list

# 현재 브로커에서 구독중인 전체 토픽 조회
docker exec kafka-streams_kafka_1 kafka-topics --describe --bootstrap-server kafka:9092
```
