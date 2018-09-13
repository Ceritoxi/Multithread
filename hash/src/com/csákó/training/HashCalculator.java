package com.csákó.training;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public class HashCalculator {

	public static void main(String[] args) {
		HashCrackOnSingleThread hash = new HashCrackOnSingleThread(hash("titkos"));
		hash.crackHash(30);
		System.out.println(hash.getResult());
	}

	public static String hash(String toHash) {
		Hasher hasher = Hashing.md5().newHasher();
		hasher.putString(toHash, StandardCharsets.UTF_8);
		return hasher.hash().toString();
	}
}