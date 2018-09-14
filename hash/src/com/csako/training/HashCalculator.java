package com.csako.training;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class HashCalculator {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		HashCrackOnSingleThread singlehash = new HashCrackOnSingleThread(hash("tit"));
		singlehash.crackHash(5);
		System.out.println(singlehash.getResult());
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		HashCrackOnMultiThread multihash = new HashCrackOnMultiThread(hash("tit"));
		multihash.crackHash(5);
		System.out.println(multihash.getResult());
		end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	public static String hash(String toHash) {
		Hasher hasher = Hashing.md5().newHasher();
		hasher.putString(toHash, StandardCharsets.UTF_8);
		return hasher.hash().toString();
	}
}